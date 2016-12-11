package com.vjames19.demo.grpc

/**
 * Created by vreventos on 12/11/16.
 */
class Config {
    companion object {
        val userServiceHost = System.getProperty("demo.userService.host") ?: "localhost"
        val userServicePort = System.getProperty("demo.userService.port")?.toInt() ?: 20000

        val userInfoHost = System.getProperty("demo.userInfo.host") ?: "localhost"
        val userInfoServicePort = System.getProperty("demo.userInfo.port")?.toInt() ?: 20001

        val userProjectsHost = System.getProperty("demo.userProjects.host") ?: "localhost"
        val userProjectsServicePort = System.getProperty("demo.userProjects.port")?.toInt() ?: 20002
    }
}
