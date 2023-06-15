package com.example.basicandroid.signUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.basicandroid.R

class SignUpActivity : AppCompatActivity() {
    private lateinit var btnBack: Button
    private lateinit var btnSignIn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()
        initialView()
    }

    private fun initialView() {
        btnBack = findViewById(R.id.btnBack)
        btnSignIn = findViewById(R.id.btnSignIn)
    }

    fun onBackTap() {
        finish()
    }
}