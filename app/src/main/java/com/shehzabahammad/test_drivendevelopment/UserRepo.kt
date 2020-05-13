package com.shehzabahammad.test_drivendevelopment

import androidx.lifecycle.MutableLiveData

/* this repo class is a ArrayList of User data class to store the user credentials. Its not a real repo class*/
class UserRepo {

    private var userList = ArrayList<User>(0)

    fun addUser(user: User) {
        userList.add(user)
    }

    fun getList(): List<User> {
        return userList
    }

}

data class User(var username: String, var password: String)