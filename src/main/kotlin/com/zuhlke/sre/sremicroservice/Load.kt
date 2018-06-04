package com.zuhlke.sre.sremicroservice


import java.util.concurrent.ExecutorService

interface Load {
   fun load(numberOfCores: Int, expectedCpuLoad: Double, executor: ExecutorService)
}

