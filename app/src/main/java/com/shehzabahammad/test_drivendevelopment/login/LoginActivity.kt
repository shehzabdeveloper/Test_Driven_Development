package com.shehzabahammad.test_drivendevelopment.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shehzabahammad.test_drivendevelopment.R
import com.shehzabahammad.test_drivendevelopment.User
import com.shehzabahammad.test_drivendevelopment.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        btnLogin.setOnClickListener(this)
        loginViewModel.response.observe(this, Observer {
            if (it) {
                startActivity(Intent(applicationContext, HomeActivity::class.java))
            } else {
                Toast.makeText(
                    applicationContext,
                    "Incorrect username/password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogin -> {
                if (etUsername.text.trim().isNotEmpty() && etPassword.text.trim().isNotEmpty()) {
                    loginViewModel.doLogin(
                        User(
                            etUsername.text.trim().toString(),
                            etPassword.text.trim().toString()
                        )
                    )
                }
            }
        }
    }
}
