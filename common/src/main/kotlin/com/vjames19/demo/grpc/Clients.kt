package com.vjames19.demo.grpc

import com.github.kristofa.brave.Brave
import com.github.kristofa.brave.grpc.BraveGrpcClientInterceptor
import com.google.common.util.concurrent.ThreadFactoryBuilder
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import java.util.concurrent.*

/**
 * Created by vreventos on 12/10/16.
 */
class Clients {
    companion object {

        fun createChannel(host: String, port: Int, brave: Brave): ManagedChannel {
            println("Creating channel for $host:$port")
            return ManagedChannelBuilder
                    .forAddress(host, port)
                    .intercept(BraveGrpcClientInterceptor.create(brave))
                    .executor(executor())
                    .usePlaintext(true)
                    .build()
        }

        private fun executor(): Executor {
            val threadFactory = ThreadFactoryBuilder()
                    .setNameFormat("grpcServerExecutor")
                    .setDaemon(true)
                    .build()

            val rejectedExecutionHandler = RejectedExecutionHandler { r, executor -> executor.queue.put(r) }

            return ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                    Runtime.getRuntime().availableProcessors() * 10, 60L, TimeUnit.SECONDS,
                    LinkedBlockingQueue(100), threadFactory, rejectedExecutionHandler)
        }

        fun serverPort(default: Int): Int {
            return System.getProperty("demo.server.port")?.toInt() ?: default
        }
    }
}
