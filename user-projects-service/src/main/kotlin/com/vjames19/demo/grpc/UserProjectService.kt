package com.vjames19.demo.grpc

import com.vjames19.demo.grpc.proto.Project
import com.vjames19.demo.grpc.proto.UserProjectServiceGrpc.UserProjectServiceImplBase
import com.vjames19.demo.grpc.proto.UserProjectsRequest
import com.vjames19.demo.grpc.proto.UserProjectsResponse
import io.grpc.stub.StreamObserver

/**
 * Created by vreventos on 12/10/16.
 */
class UserProjectService : UserProjectServiceImplBase() {

    override fun getProjectsForUser(request: UserProjectsRequest, responseObserver: StreamObserver<UserProjectsResponse>) {
        val response = UserProjectsResponse.newBuilder().apply {
            addAllProject(projects)
        }.build()

        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }

    companion object {
        val projects: List<Project> by lazy {
            (1..1000).map {
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
