package com.zuhlke.sre.sremicroservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class InfoController {


    @GetMapping("/isAlive")
    fun greeting() =
            IsAlive("Active")

    @GetMapping("/version")
    fun getVersion() =
            Version(SreMicroserviceApplication.version)
}