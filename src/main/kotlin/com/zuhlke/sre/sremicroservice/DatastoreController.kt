package com.zuhlke.sre.sremicroservice

import org.litote.kmongo.KMongo
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DatastoreController {
    val logger = LoggerFactory.getLogger(DatastoreController::class.java)

    @PostMapping("/saveUser")
    fun saveUser(user: User): User {
        logger.debug("Reached /saveUser endpoint")
        val mongoClient = KMongo.createClient("localhost", 27017)
        val db = mongoClient.getDatabase("test")
        val col = db.getCollection<User>()
        logger.debug("Connected to MongoDB")
        col.insertOne(user)
        logger.debug("Inserted user")
        return user
    }

    @GetMapping("/getUserByName")
    fun getUser(@RequestParam("name") name: String): User? {
        logger.debug("Reached /getUserByName endpoint")
        val mongoClient = KMongo.createClient("localhost", 27017)
        val db = mongoClient.getDatabase("test")
        val col = db.getCollection<User>()
        logger.debug("Connected to MongoDB")
        val result = col.findOne(User :: name eq name)
        logger.debug("Retrieved user")
        return result
    }

}