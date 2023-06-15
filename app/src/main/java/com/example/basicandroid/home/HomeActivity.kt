package com.example.basicandroid.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.basicandroid.R
import com.example.basicandroid.department.DepartmentActivity
import com.example.basicandroid.employee.EmployeeActivity
import com.example.basicandroid.signIn.SignInActivity


class HomeActivity : AppCompatActivity(), OnClickListener {
    private lateinit var btnDepartment: LinearLayout
    private lateinit var btnEmployee: LinearLayout
    private lateinit var btnExit: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
        initialView()
    }

    private fun initialView() {
        btnDepartment = findViewById(R.id.btnDepartment)
        btnEmployee = findViewById(R.id.btnEmployee)
        btnExit = findViewById(R.id.btnExit)
        btnDepartment.setOnClickListener(this)
        btnEmployee.setOnClickListener(this)
        btnExit.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnDepartment -> {
                val intent = Intent(baseContext, DepartmentActivity::class.java)
                startActivity(intent)
            }

            R.id.btnEmployee -> {
                val intent = Intent(baseContext, EmployeeActivity::class.java)
                startActivity(intent)
            }

            R.id.btnExit -> {
                val intent = Intent(baseContext, SignInActivity::class.java)
                startActivity(intent)
            }
        }
    }
}