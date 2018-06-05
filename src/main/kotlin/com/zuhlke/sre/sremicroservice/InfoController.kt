package com.zuhlke.sre.sremicroservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.Executor
import java.util.concurrent.atomic.AtomicLong

@RestController
class InfoController {

    val counter = AtomicLong()

    @GetMapping("/isAlive")
    fun greeting() =
            IsAlive("Active")

    @GetMapping("/version")
    fun getVersion() =
            Version(SreMicroserviceApplication.version)
}