package com.vjames19.demo.grpc

import com.vjames19.demo.grpc.Clients.Companion.serverPort
import com.vjames19.demo.grpc.Config.Companion.userInfoServicePort
import com.vjames19.demo.grpc.proto.UserInfo
import com.vjames19.demo.grpc.proto.UserInfoRequest
import com.vjames19.demo.grpc.proto.UserInfoServiceGrpc.UserInfoServiceImplBase
import io.grpc.Status
import io.grpc.stub.StreamObserver

/**
 * Created by vreventos on 12/10/16.
 */
class UserInfoService : UserInfoServiceImplBase() {

    override fun getUser(request: UserInfoRequest, responseObserver: StreamObserver<UserInfo>) {
        responseObserver.single {
            if (!users.contains(request.id)) {
                throw Status.NOT_FOUND.asException()
            } else {
                users[request.id]!!
            }
        }

    }

    companion object {
        val users: Map<Long, UserInfo> = users()

        private fun users(): Map<Long, UserInfo> {
            val names = listOf("Victor", "John", "Juan", "Pedro", "James", "Ly")
            val pairs = names.mapIndexed { i, name ->
                i.toLong() to user(i.toLong(), name)
            }.toTypedArray()

            return hashMapOf(*pairs)
        }

        private fun user(userId: Long, userName: String): UserInfo {
            return UserInfo.newBuilder().apply {
                id = userId
                name = userName
                email = "${userName}@test.com"
                phone = "787-123-1234"
            }.build()
        }
    }
}

fun main(args: Array<String>) {
    GrpcServer(UserInfoService(), serverPort(userInfoServicePort), Tracing.brave("userInfoService"))
            .startAndBlock()
}
