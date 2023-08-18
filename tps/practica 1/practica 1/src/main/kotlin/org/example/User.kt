package org.example

import java.time.LocalDate
import java.util.*

class User(
    var nameAndSubName: String,
    var username: String,
    var email: String,
    var birthdate: LocalDate
) {
    var followers : MutableList<User>
    var following : MutableList<User>

    init {
        this.followers = mutableListOf()
        this.following = mutableListOf()
    }

    fun age(): Int {
        return this.birthdate.until(LocalDate.now()).years
    }

    fun isGmail(): Boolean {
        return this.email.endsWith("@gmail.com")
    }

    fun getFollowersIFollow(): List<User> {
        return this.following.filter { it.followers.contains(this) }
    }

    fun addFollower(user: User) : User {
        this.followers.add(user)
        return this
    }

    fun follow(user: User) : User {
        this.following.add(user)
        user.addFollower(this)
        return this
    }

    override fun toString(): String {
        return "$nameAndSubName"
    }
}