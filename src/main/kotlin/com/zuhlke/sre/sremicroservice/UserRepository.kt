package com.zuhlke.sre.sremicroservice

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, String> {
    fun findUserByName(name: String) : List<User>
}