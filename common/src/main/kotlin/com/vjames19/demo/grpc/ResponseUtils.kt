package com.vjames19.demo.grpc

import io.grpc.Status
import io.grpc.stub.ClientResponseObserver
import io.grpc.stub.StreamObserver
import java.util.concurrent.CompletableFuture

/**
 * Created by vreventos on 12/10/16.
 */

fun <V> StreamObserver<V>.single(block: () -> V) {
    try {
        val result = block()
        this.onNext(result)
        this.onCompleted()
    } catch (e: Exception) {
        this.onError(Status.fromThrowable(e).asException())
    }
}

fun <V> CompletableFuture<V>.respond(responseObserver: StreamObserver<V>): Unit {
    this.handle { v, throwable ->
        if (throwable != null) {
            responseObserver.onError(Status.fromThrowable(throwable).asException())
        } else {
            responseObserver.onNext(v)
            responseObserver.onCompleted()
        }
    }
}
