package com.vjames19.demo.grpc

import com.github.kristofa.brave.Brave
import com.github.kristofa.brave.grpc.BraveGrpcServerInterceptor

import io.grpc.BindableService
import io.grpc.Server
import io.grpc.ServerBuilder
import io.grpc.ServerInterceptors

import java.io.IOException
import kotlin.concurrent.thread

class GrpcServer(private val bindableService: BindableService,
                 private val port: Int) {
    private var server: Server? = null

    @Throws(IOException::class)
    fun start() {
        server = ServerBuilder.forPort(port).addService(ServerInterceptors.intercept(bindableService, BraveGrpcServerInterceptor(brave))).build().start()
        Runtime.getRuntime().addShutdownHook(object : Thread() {
            override fun run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down")
                this@GrpcServer.stop()
                System.err.println("*** server shut down")
            }
        })
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
