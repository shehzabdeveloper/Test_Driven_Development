package com.shehzabahammad.test_drivendevelopment.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.shehzabahammad.test_drivendevelopment.User
import com.shehzabahammad.test_drivendevelopment.UserRepo

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private var userRepo = UserRepo()

    var response: MutableLiveData<Boolean> = MutableLiveData()
        private set

    fun validateUser(loggedUser: User): Boolean {
        userRepo.addUser(User("android", "123456"))
        val userList = userRepo.getList()
        if (userList.contains(loggedUser)) {
            return true
        }
        return false
    }

    fun doLogin(loggedUser: User) {
        var user = User("android", "123456")
        userRepo.addUser(user)
        var list = userRepo.getList()
        if (list.contains(loggedUser)) {
            response.postValue(true)
        } else {
            response.postValue(false)
        }
    }

}