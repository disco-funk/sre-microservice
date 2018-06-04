package com.zuhlke.sre.sremicroservice

import org.litote.kmongo.KMongo
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DatastoreController {

    @PostMapping("/saveUser")
    fun saveUser(user: User): User {
        val mongoClient = KMongo.createClient("localhost", 27017)
        val db = mongoClient.getDatabase("test")
        val col = db.getCollection<User>()
        col.insertOne(user)

        return user
    }

    @GetMapping("/getUserByName")
    fun getUser(@RequestParam("name") name: String): User? {
        val mongoClient = KMongo.createClient("localhost", 27017)
        val db = mongoClient.getDatabase("test")
        val col = db.getCollection<User>()

        val user: User? = col.findOne(User :: name eq name)

        return user
    }

}