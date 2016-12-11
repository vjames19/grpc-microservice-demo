package com.vjames19.demo.grpc.client

import com.vjames19.demo.grpc.Clients
import com.vjames19.demo.grpc.Config
import com.vjames19.demo.grpc.Config.Companion.userServicePort
import com.vjames19.demo.grpc.Tracing
import com.vjames19.demo.grpc.proto.UserRequest
import com.vjames19.demo.grpc.proto.UserServiceGrpc
import com.vjames19.demo.grpc.toCompletableFuture
import io.grpc.Status
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread

/**
 * Created by vreventos on 12/10/16.
 */
fun main(args: Array<String>) {
    val userServiceChannel = Clients.createChannel("localhost", userServicePort, Tracing.brave("main-client"))
    val service = UserServiceGrpc.newFutureStub(userServiceChannel)

    val totalTime = AtomicLong()
    val totalRequests = AtomicInteger()
    (1..4).map {
        thread {
            (1..10000).map {
                val id = ThreadLocalRandom.current().nextLong(1, 5)
                totalRequests.incrementAndGet()

                val start = System.nanoTime()
                val future = service.getUser(UserRequest.newBuilder().apply { this.id = id }.build()).toCompletableFuture()
                future.handle { userResponse, throwable ->
                    val end = System.nanoTime() - start
                    totalTime.addAndGet(end)
                    if (throwable != null) {
                        val status = Status.fromThrowable(throwable)
//                        println("request for id $id failed $status took: $end")
                    } else {
//                        println("request for id $id success: ${userResponse.user.id} took: $end")
                    }

                    null
                }.get()
            }
//                    .forEach {
//                it.get()
//            }
        }
    }.forEach { it.join() }

    val totalSeconds = TimeUnit.NANOSECONDS.toSeconds(totalTime.get())
    println("${totalRequests.get()} requests, took: $totalSeconds")
    println("${totalRequests.get().toDouble() / totalSeconds} req/s")
    println("average response time: ${totalSeconds.toDouble() / totalRequests.get()}")
}
