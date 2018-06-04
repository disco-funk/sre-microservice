package com.zuhlke.sre.sremicroservice

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.Executors

@RestController
class HeavyLoadController {
    var executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())

    @PostMapping("/startHeavyLoad")
    fun heavyLoad(@RequestParam("expectedCpuLoad") expectedCpuLoad: Double) {
        if (executor.isShutdown) {
            executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
        }
        HeavyLoad.load(Runtime.getRuntime().availableProcessors(), expectedCpuLoad, executor)
    }

    @PostMapping("/stopHeavyLoad")
    fun stopThreads() = executor.shutdownNow()
}

