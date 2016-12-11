package com.vjames19.demo.grpc

import io.grpc.BindableService
import io.grpc.Server
import io.grpc.ServerBuilder
import java.io.IOException

class GrpcServer(private val bindableService: BindableService,
                 private val port: Int) {
    private var server: Server? = null

    @Throws(IOException::class)
    fun start() {
        println("Starting server")
        server = ServerBuilder.forPort(port)
                .addService(bindableService)
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

}
