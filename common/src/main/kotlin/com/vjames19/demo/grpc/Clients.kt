package com.vjames19.demo.grpc

import io.grpc.ManagedChannelBuilder

/**
 * Created by vreventos on 12/10/16.
 */
class Clients {
    companion object {
        val userServicePort = 20000
        val userInfoServicePort = 20001
        val userProjectsServicePort = 20002

        fun createChannel(host: String, port: Int) = ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext(true)
                .build()
    }
}
