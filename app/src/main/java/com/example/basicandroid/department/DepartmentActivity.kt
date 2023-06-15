package com.example.basicandroid.department

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basicandroid.R


class DepartmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_department)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Phòng ban"
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

    fun onDepartEmployeeClick() {
        Toast.makeText(this, "Nhân sự", Toast.LENGTH_SHORT).show()
    }

    fun onDepartAdminClick() {
        Toast.makeText(this, "Hành chính", Toast.LENGTH_SHORT).show()
    }

    fun onDepartTrainingClick() {
        Toast.makeText(this, "Đào tạo", Toast.LENGTH_SHORT).show()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search, menu)
        return true
    }
}