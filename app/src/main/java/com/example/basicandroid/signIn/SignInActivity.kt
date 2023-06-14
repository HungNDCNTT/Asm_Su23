package com.example.basicandroid.signIn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.basicandroid.R
import com.example.basicandroid.home.HomeActivity
import com.example.basicandroid.signUp.SignUpActivity

class SignInActivity : AppCompatActivity() {
    lateinit var btnSignIn: Button
    lateinit var btnSignUp: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        supportActionBar?.hide()
        initialView()
        onSignUpClick()
    }

    private fun initialView() {
        btnSignIn = findViewById(R.id.btnSignIn)
        btnSignUp = findViewById(R.id.btnSignUp)
    }

    private fun onSignUpClick() {
        btnSignUp.setOnClickListener {
            val intent = Intent(baseContext, SignUpActivity::class.java)
            startActivity(intent)
        }
        btnSignIn.setOnClickListener {
            val intent = Intent(baseContext, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}