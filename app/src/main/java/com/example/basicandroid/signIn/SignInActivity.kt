package com.example.basicandroid.signIn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.example.basicandroid.R
import com.example.basicandroid.appConfigs.AppConfigs
import com.example.basicandroid.home.HomeActivity
import com.example.basicandroid.signUp.SignUpActivity
import com.example.basicandroid.utils.SharedPreferencesHelper
import com.google.android.material.textfield.TextInputLayout

class SignInActivity : AppCompatActivity() {
    private lateinit var btnSignIn: Button
    private lateinit var btnSignUp: Button
    private lateinit var edtUserName: TextInputLayout
    private lateinit var edtPassword: TextInputLayout
    private lateinit var cbRememberMe: CheckBox
    private var isShowing = false
    private var isChecked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        supportActionBar?.hide()
        initialView()
    }

    private fun initialView() {
        btnSignIn = findViewById(R.id.btnSignIn)
        btnSignUp = findViewById(R.id.btnSignUp)
        edtUserName = findViewById(R.id.tfUserName)
        edtPassword = findViewById(R.id.tfPassword)
        cbRememberMe = findViewById(R.id.cbRemeberMe)
        cbRememberMe.setOnClickListener {
            isChecked = cbRememberMe.isChecked
        }
        onSignUpClick()
    }

    private fun checkExitAccount(): Boolean {
        val value = SharedPreferencesHelper.get(this, AppConfigs.userKey, "")
        print(value)
        return false
    }

    private fun onSignUpClick() {
        btnSignUp.setOnClickListener {
            val intent = Intent(baseContext, SignUpActivity::class.java)
            startActivity(intent)
        }
        btnSignIn.setOnClickListener {
            if (validateUsername()) {
                if (validatePassword()) {
                    if (checkExitAccount()) {
                        val intent = Intent(baseContext, HomeActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }

    private fun validateUsername(): Boolean {
        val userName = edtUserName.editText?.text?.trim()
        if (userName == null || userName == "" && !isShowing) {
            isShowing = true
            Toast.makeText(this, "Nhập username", Toast.LENGTH_LONG).show()
            isShowing = false
            return false
        }
        return true
    }

    private fun validatePassword(): Boolean {
        val password = edtPassword.editText?.text?.trim().toString()
        val isInvalid = isValidPassword(password)
        if (!isInvalid && !isShowing) {
            isShowing = true
            Toast.makeText(this, "Sai format password", Toast.LENGTH_LONG).show()
            isShowing = false
            return false
        }
        return true
    }

    private fun isValidPassword(password: String): Boolean {
        if (password.length < 8) return false
        if (password.firstOrNull { it.isDigit() } == null) return false
        if (password.filter { it.isLetter() }.firstOrNull { it.isUpperCase() } == null) return false
        if (password.filter { it.isLetter() }.firstOrNull { it.isLowerCase() } == null) return false
        if (password.firstOrNull { !it.isLetterOrDigit() } == null) return false

        return true
    }

}