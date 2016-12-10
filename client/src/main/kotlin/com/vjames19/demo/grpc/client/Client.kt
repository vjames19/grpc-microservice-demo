package com.vjames19.demo.grpc.client

import com.vjames19.demo.grpc.proto.UserRequest
import com.vjames19.demo.grpc.proto.UserServiceGrpc
import com.vjames19.demo.grpc.toCompletableFuture
import io.grpc.ManagedChannelBuilder

/**
 * Created by vreventos on 12/10/16.
 */

fun main(args: Array<String>) {
    val userServiceChannel = ManagedChannelBuilder.forAddress("localhost", 15001)
            .loadBalancerFactory()
            .usePlaintext(true)
            .build()
    val service = UserServiceGrpc.newFutureStub(userServiceChannel)

    (1..1000).map {
        val future = service.getUser(UserRequest.newBuilder().apply { id = it.toLong() }.build()).toCompletableFuture()
        val id = it

        future.handle { userResponse, throwable ->
            if (throwable != null) {
                println("request for id $id failed")
                throwable.printStackTrace(System.out)
            } else {
                println("request for id $id success: ${userResponse.toString()}")
            }

            null
        }
    }.forEach {
        it.get()
    }
}

