package com.zuhlke.sre.sremicroservice

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.Executors

@RestController
class HeavyLoadController {
    var executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
    val logger = LoggerFactory.getLogger(HeavyLoadController::class.java)

    @PostMapping("/startHeavyLoad")
    fun heavyLoad(@RequestParam("expectedCpuLoad") expectedCpuLoad: Double) {
        logger.debug("Reached startHeavyLoad endpoint")
        if (executor.isShutdown) {
            executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
            logger.debug("Executor of threads is shutdown. Starting executor...")
        }
        HeavyLoad.load(Runtime.getRuntime().availableProcessors(), expectedCpuLoad, executor)
    }

    @PostMapping("/stopHeavyLoad")
    fun stopThreads() {
        logger.debug("Reached stopHeavyLoad")
        executor.shutdownNow()
    }
}

