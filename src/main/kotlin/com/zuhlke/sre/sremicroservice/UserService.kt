package com.zuhlke.sre.sremicroservice

interface UserService {
    fun saveUser(user: User) : User
    fun findUserByName(name: String) : List<User>
}