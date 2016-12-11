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
        val userServicePort = 20000
        val userInfoServicePort = 20001
        val userProjectsServicePort = 20002

        fun createChannel(host: String, port: Int, brave: Brave): ManagedChannel = ManagedChannelBuilder
                .forAddress(host, port)
                .intercept(BraveGrpcClientInterceptor.create(brave))
                .executor(executor())
                .usePlaintext(true)
                .build()

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
    }
}
