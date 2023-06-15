package com.example.basicandroid.signUp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basicandroid.R
import com.example.basicandroid.appConfigs.AppConfigs
import com.example.basicandroid.models.UserEntity
import com.example.basicandroid.signIn.SignInActivity
import com.example.basicandroid.utils.SharedPreferencesHelper
import com.google.android.material.textfield.TextInputLayout
import com.google.gson.Gson


class SignUpActivity : AppCompatActivity() {
    private lateinit var btnBack: Button
    private lateinit var btnSignIn: Button
    private lateinit var edtUserName: TextInputLayout
    private lateinit var edtPassword: TextInputLayout
    private lateinit var edtRePassword: TextInputLayout
    private lateinit var cbRememberMe: CheckBox
    private var isShowing = false
    private var isChecked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()
        initialView()
    }

    private fun initialView() {
        btnBack = findViewById(R.id.btnBack)
        btnSignIn = findViewById(R.id.btnSignIn)
        edtUserName = findViewById(R.id.tfUserName)
        edtPassword = findViewById(R.id.tfPassword)
        edtRePassword = findViewById(R.id.tfRePassword)
        cbRememberMe = findViewById(R.id.cbRemeberMe)
        cbRememberMe.setOnClickListener {
            isChecked = cbRememberMe.isChecked
        }
        onBtnSignInClick()

    }

    private fun onBtnSignInClick() {

        btnSignIn.setOnClickListener {
            if (validateUsername() && validatePassword()) {
                val userEntity = UserEntity(
                    edtUserName.editText?.text?.trim().toString(),
                    edtPassword.editText?.text?.trim().toString(),
                    isChecked
                )
                val gson = Gson()
                val json = gson.toJson(userEntity)
                SharedPreferencesHelper.add(this, AppConfigs.userKey, json)
                val intent = Intent(baseContext, SignInActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }

    private fun validateUsername(): Boolean {
        val userName = edtUserName.editText?.text?.trim()
        return if (userName == null || userName == "" && !isShowing) {
            isShowing = true
            Toast.makeText(this, "Nhập username", Toast.LENGTH_LONG).show()
            isShowing = false
            false
        } else {
            true
        }
    }

    private fun validatePassword(): Boolean {
        val password = edtPassword.editText?.text?.trim().toString()
        val rePassword = edtRePassword.editText?.text?.trim()
        val isInvalid = isValidPassword(password)
        if (!isInvalid && !isShowing) {
            isShowing = true
            Toast.makeText(this, "Sai format password", Toast.LENGTH_LONG).show()
            isShowing = false
            return false
        }
        if (rePassword != null) {
            if (rePassword != password) {
                isShowing = true
                Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_LONG).show()
                isShowing = false
                return false
            }

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

    fun onBackTap() {
        finish()
    }
}