package com.zuhlke.sre.sremicroservice

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DatastoreController {
    val logger = LoggerFactory.getLogger(DatastoreController::class.java)

    @Autowired
    lateinit var userService: UserService

    @PostMapping("/saveUser")
    fun saveUser(user: User): User {
        logger.debug("Reached /saveUser endpoint")
        userService.saveUser(user)
        logger.debug("Inserted user")
        return user
    }

    @GetMapping("/getUserByName")
    fun getUser(@RequestParam("name") name: String): List<User>? {
        logger.debug("Reached /getUserByName endpoint")
        val user = userService.findUserByName(name)
        logger.debug("Retrieved user")
        return user
    }

}