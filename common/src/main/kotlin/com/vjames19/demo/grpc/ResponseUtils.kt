package com.vjames19.demo.grpc

import io.grpc.Status
import io.grpc.stub.StreamObserver

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
