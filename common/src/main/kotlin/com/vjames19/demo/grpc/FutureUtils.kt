package com.vjames19.demo.grpc

import com.google.common.util.concurrent.FutureCallback
import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.ListenableFuture
import java.util.concurrent.CompletableFuture

/**
 * Created by vreventos on 12/10/16.
 */
fun <V> ListenableFuture<V>.toCompletableFuture(): CompletableFuture<V> {
    val future = CompletableFuture<V>()
    Futures.addCallback(this, object: FutureCallback<V> {
        override fun onSuccess(result: V?) {
            future.complete(result)
        }

        override fun onFailure(t: Throwable?) {
            future.completeExceptionally(t)
        }
    })

    return future
}
