package com.example.basicandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basicandroid.signIn.SignInActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val background: Thread = object : Thread() {
            override fun run() {
                try {
                    // Thread will sleep for 5 seconds
                    sleep((2 * 1000).toLong())

                    // After 5 seconds redirect to another intent
                    val intent = Intent(baseContext, SignInActivity::class.java)
                    startActivity(intent)

                    //Remove activity
                    finish()
                } catch (e: Exception) {
                    print(e)
                }
            }
        }
        // start thread
        // start thread
        background.start()
    }
}