package com.zuhlke.sre.sremicroservice

import reactor.core.publisher.toMono

class MongoService {
    fun getSomeData() {
        val client = ApplicationConfiguration().reactiveMongoClient()

        val block = client.listDatabases().first().toMono().block()

        println(block.toString())
    }
}