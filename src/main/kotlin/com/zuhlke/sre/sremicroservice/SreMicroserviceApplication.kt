package com.zuhlke.sre.sremicroservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SreMicroserviceApplication

fun main(args: Array<String>) {
    runApplication<SreMicroserviceApplication>(*args)
}
