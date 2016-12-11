package com.vjames19.demo.grpc

import com.github.kristofa.brave.Brave
import com.github.kristofa.brave.Sampler
import zipkin.Span
import zipkin.reporter.AsyncReporter
import zipkin.reporter.Reporter
import zipkin.reporter.okhttp3.OkHttpSender

/**
 * Created by vreventos on 12/11/16.
 */
class Tracing {
    companion object {
        var zipkinReporter: Reporter<Span>? = null

        fun brave(serviceName: String, zipkinHost: String = zipkinHost()): Brave {
            if (zipkinReporter == null) {
                zipkinReporter = AsyncReporter.builder(OkHttpSender.create("http://$zipkinHost:9411/api/v1/spans"))
                        .build()
            }
            return Brave.Builder(serviceName)
                    .traceSampler(Sampler.ALWAYS_SAMPLE)
                    .reporter(zipkinReporter)
                    .build()
        }

        fun zipkinHost(): String {
            val host = System.getProperty("demo.zipkin.host")
            if (host.isNullOrEmpty()) {
                System.err.println("Setup demo.zipkin.host system property to be able to trace the calls")
                System.exit(-1)
            }

            return host
        }
    }
}
