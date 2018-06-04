package com.zuhlke.sre.sremicroservice

import java.util.concurrent.ExecutorService

object HeavyLoad: Load{

    override fun load(numberOfCores: Int, expectedCpuLoad: Double, executor: ExecutorService) {

        for (i in numberOfCores downTo 0 step 1) {
            executor.submit {
                loadCpu(expectedCpuLoad)
            }
        }
    }

   fun loadCpu(expectedCpuLoad: Double){
       while(true) {
        if (System.currentTimeMillis() % 100 == 0L)
           Thread.sleep(Math.floor((1-expectedCpuLoad) * 100).toLong())
       }
   }

}

