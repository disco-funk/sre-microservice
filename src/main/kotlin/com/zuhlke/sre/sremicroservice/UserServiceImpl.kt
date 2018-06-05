package com.zuhlke.sre.sremicroservice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {
    @Autowired
    lateinit var userRepository : UserRepository

    override fun saveUser(user: User) : User {
        userRepository.save(user)
        return user
    }

    override fun findUserByName(name: String): List<User> {
        return userRepository.findUserByName(name)
    }
}