package com.vjames19.demo.grpc.client

import com.vjames19.demo.grpc.Clients
import com.vjames19.demo.grpc.proto.UserRequest
import com.vjames19.demo.grpc.proto.UserServiceGrpc
import com.vjames19.demo.grpc.toCompletableFuture
import io.grpc.Status
import kotlin.concurrent.timerTask

/**
 * Created by vreventos on 12/10/16.
 */
fun main(args: Array<String>) {
    val userServiceChannel = Clients.createChannel("localhost", Clients.userServicePort)
    val service = UserServiceGrpc.newFutureStub(userServiceChannel)

    (1..20).map {
        val future = service.getUser(UserRequest.newBuilder().apply { id = it.toLong() }.build()).toCompletableFuture()
        val id = it

        val start = System.nanoTime()
        future.handle { userResponse, throwable ->
            val end = System.nanoTime() - start
            if (throwable != null) {
                val status = Status.fromThrowable(throwable)
                println("request for id $id failed $status took: $end")
            } else {
                println("request for id $id success: ${userResponse.user.id} took: $end")
            }

            null
        }
    }.forEach {
        it.get()
    }
}
