package com.zuhlke.sre.sremicroservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SreMicroserviceApplication {
    companion object {
        var version = "Unknown"
    }
}

fun main(args: Array<String>) {
    if (args.size == 1) SreMicroserviceApplication.version = args[0]
    runApplication<SreMicroserviceApplication>(*args)
}
