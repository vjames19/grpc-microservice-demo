package com.vjames19.demo.grpc

import com.vjames19.demo.grpc.proto.*
import com.vjames19.demo.grpc.proto.UserInfoServiceGrpc.UserInfoServiceFutureStub
import com.vjames19.demo.grpc.proto.UserProjectServiceGrpc.UserProjectServiceFutureStub
import com.vjames19.demo.grpc.proto.UserServiceGrpc.UserServiceImplBase
import io.grpc.stub.StreamObserver

/**
 * Created by vreventos on 12/10/16.
 */
class UserService(val userInfoService: UserInfoServiceFutureStub,
                  val userProjectService: UserProjectServiceFutureStub) : UserServiceImplBase() {

    override fun getUser(request: UserRequest, responseObserver: StreamObserver<UserResponse>) {
        val userInfoRequest = UserInfoRequest.newBuilder()
                .apply { id = request.id }
                .build()
        val userInfoFuture = userInfoService.getUser(userInfoRequest).toCompletableFuture()

        val userProjectsRequest = UserProjectsRequest.newBuilder()
                .apply { id = request.id }
                .build()
        val userProjectsFuture = userProjectService.getProjectsForUser(userProjectsRequest).toCompletableFuture()

        userInfoFuture.thenCombineAsync(userProjectsFuture, { userInfo, userProjects ->
            UserResponse.newBuilder().apply {
                user = userInfo
                addAllProject(userProjects.projectList)
            }.build()
        }).respond(responseObserver)
    }
}

fun main(args: Array<String>) {
    GrpcServer(UserService(createUserInfoService(), createUserProjectsService()), Clients.userServicePort).apply {
        start()
        blockUntilShutdown()
    }
}

fun createUserInfoService(): UserInfoServiceFutureStub {
    val channel = Clients.createChannel("localhost", Clients.userInfoServicePort)
    return UserInfoServiceGrpc.newFutureStub(channel)
}

fun createUserProjectsService(): UserProjectServiceFutureStub {
    val channel = Clients.createChannel("localhost", Clients.userProjectsServicePort)
    return UserProjectServiceGrpc.newFutureStub(channel)
}
