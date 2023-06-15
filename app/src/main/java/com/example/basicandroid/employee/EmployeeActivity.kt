package com.example.basicandroid.employee

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basicandroid.R
import com.example.basicandroid.models.EmployeeEntity


class EmployeeActivity : AppCompatActivity() {
    var employees= ArrayList<EmployeeEntity>()
    lateinit var rcvEmployee: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)
        initialView()
    }

    private fun initialView() {
        employees.add(EmployeeEntity("AAAA", "asd", "asdasd"))
        rcvEmployee = findViewById(R.id.rcvEmploy)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Nhân viên"
        val adapter = EmployeeAdapter(employees)
        rcvEmployee.adapter = adapter
        rcvEmployee.layoutManager = LinearLayoutManager(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search, menu)
        return true
    }
}