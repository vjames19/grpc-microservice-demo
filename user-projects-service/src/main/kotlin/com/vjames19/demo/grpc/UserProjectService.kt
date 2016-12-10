package com.vjames19.demo.grpc

import com.google.common.util.concurrent.FutureCallback
import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.ListenableFuture
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
        userExists(request.id).handle { exists, throwable ->
            responseObserver.single {
                if (throwable != null) {
                    throw throwable
                }

                if (exists) {
                    UserProjectsResponse.newBuilder().apply {
                        addAllProject(projects)
                    }.build()
                } else {
                  throw Status.NOT_FOUND.asException()
                }
            }
        }
    }

    fun userExists(id: Long): CompletableFuture<Boolean> {
        val request = UserRequest.newBuilder().apply { this.id = id }.build()
        return userInfoService.getUser(request).toCompletableFuture().thenApply {
            it != null
        }
    }

    companion object {
        val projects: List<Project> by lazy {
            (1..10000).map {
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
