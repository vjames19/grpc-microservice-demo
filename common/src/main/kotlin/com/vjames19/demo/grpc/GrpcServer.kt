package com.vjames19.demo.grpc

import com.github.kristofa.brave.Brave
import com.github.kristofa.brave.grpc.BraveGrpcServerInterceptor
import com.google.common.util.concurrent.ThreadFactoryBuilder
import io.grpc.BindableService
import io.grpc.Server
import io.grpc.ServerBuilder
import io.grpc.ServerInterceptors
import java.io.IOException
import java.util.concurrent.*
import java.util.concurrent.atomic.AtomicInteger

class GrpcServer(private val bindableService: BindableService,
                 private val port: Int,
                 private val brave: Brave) {
    private var server: Server? = null

    fun startAndBlock(): Unit {
        start()
        blockUntilShutdown()
    }

    @Throws(IOException::class)
    fun start() {
        println("Starting server for service ${bindableService.javaClass.name} on port $port")
        server = ServerBuilder.forPort(port)
                .addService(ServerInterceptors.intercept(bindableService, BraveGrpcServerInterceptor.create(brave)))
                .executor(executor())
                .build()
                .start()

        Runtime.getRuntime().addShutdownHook(object : Thread() {
            override fun run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down")
                this@GrpcServer.stop()
                System.err.println("*** server shut down")
            }
        })

        println("Started server")
    }

    fun stop() {
        server?.let { it.shutdown() }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    @Throws(InterruptedException::class)
    fun blockUntilShutdown() {
        server?.let { it.awaitTermination() }
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

}
