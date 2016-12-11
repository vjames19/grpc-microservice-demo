package com.vjames19.demo.grpc

import com.vjames19.demo.grpc.proto.*
import com.vjames19.demo.grpc.proto.UserProjectServiceGrpc.UserProjectServiceImplBase
import io.grpc.Status
import io.grpc.stub.StreamObserver
import java.util.concurrent.CompletableFuture

/**
 * Created by vreventos on 12/10/16.
 */
class UserProjectService(val userInfoService: UserInfoServiceGrpc.UserInfoServiceFutureStub) : UserProjectServiceImplBase() {

    override fun getProjectsForUser(request: UserProjectsRequest, responseObserver: StreamObserver<UserProjectsResponse>) {
        responseObserver.respond(userProjects(request.id))
    }

    fun userProjects(id: Long): CompletableFuture<UserProjectsResponse> {
        return userExists(id).thenApplyAsync { exists ->
            if (exists) {
                UserProjectsResponse.newBuilder().apply {
                    addAllProject(projects)
                }.build()
            } else {
                throw Status.NOT_FOUND.asException()
            }
        }
    }

    fun userExists(id: Long): CompletableFuture<Boolean> {
        val request = UserInfoRequest.newBuilder().apply { this.id = id }.build()
        return userInfoService.getUser(request).toCompletableFuture().thenApply {
            it != null
        }
    }

    companion object {
        val projects: List<Project> by lazy {
            (1..100).map {
                project(it.toLong(), "project $it")
            }
        }

        private fun project(projectId: Long, projectName: String): Project {
            return Project.newBuilder().apply {
                id = projectId
                name = projectName
                description = "$projectName description"
            }.build()
        }
    }
}

fun main(args: Array<String>) {
    GrpcServer(UserProjectService(createUserInfoService()), Clients.userProjectsServicePort, Tracing.brave("userProjects"))
        .startAndBlock()
}

fun createUserInfoService(): UserInfoServiceGrpc.UserInfoServiceFutureStub {
    val channel = Clients.createChannel("localhost", Clients.userInfoServicePort, Tracing.brave("UserProjectService: userInfo Client"))
    return UserInfoServiceGrpc.newFutureStub(channel)
}
