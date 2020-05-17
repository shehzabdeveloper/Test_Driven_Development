package com.shehzabahammad.test_drivendevelopment.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shehzabahammad.test_drivendevelopment.User
import com.shehzabahammad.test_drivendevelopment.getOrAwaitValue
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginViewModelTest {
    private lateinit var loginViewModel: LoginViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        loginViewModel = LoginViewModel(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun validateUser_Boolean() {

        val user = User("android", "123456")
        assertTrue(loginViewModel.validateUser(user))
    }

    @Test
    fun doLogin_LiveData() {

        val user = User("android", "123456")
        loginViewModel.doLogin(user)
        assertTrue(loginViewModel.response.getOrAwaitValue())
    }
}