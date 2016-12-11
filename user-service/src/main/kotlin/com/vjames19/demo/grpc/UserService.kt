package com.vjames19.demo.grpc

import com.vjames19.demo.grpc.Clients.Companion.serverPort
import com.vjames19.demo.grpc.Config.Companion.userInfoHost
import com.vjames19.demo.grpc.Config.Companion.userInfoServicePort
import com.vjames19.demo.grpc.Config.Companion.userProjectsHost
import com.vjames19.demo.grpc.Config.Companion.userProjectsServicePort
import com.vjames19.demo.grpc.Config.Companion.userServicePort
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

        val response = userInfoFuture.thenCombineAsync(userProjectsFuture, { userInfo, userProjects ->
            UserResponse.newBuilder().apply {
                user = userInfo
                addAllProject(userProjects.projectList)
            }.build()
        })

        responseObserver.respond(response)
    }
}

fun main(args: Array<String>) {
    GrpcServer(UserService(createUserInfoService(), createUserProjectsService()), serverPort(userServicePort), Tracing.brave("userService"))
            .startAndBlock()
}

fun createUserInfoService(): UserInfoServiceFutureStub {
    val channel = Clients.createChannel(userInfoHost, userInfoServicePort, Tracing.brave("UserService: userInfo client"))
    return UserInfoServiceGrpc.newFutureStub(channel)
}

fun createUserProjectsService(): UserProjectServiceFutureStub {
    val channel = Clients.createChannel(userProjectsHost, userProjectsServicePort, Tracing.brave("UserService: userProjects client"))
    return UserProjectServiceGrpc.newFutureStub(channel)
}
