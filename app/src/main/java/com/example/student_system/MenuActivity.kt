package com.example.student_system

import android.os.Bundle
import android.content.Intent
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.menuLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onClickButtonProfile(view: View) {
        val destination = "http://188.124.37.32:3001/dashboard/get"
        val intent = Intent(this, MainActivity::class.java).apply {
            // Отправляем destination в MainActivity
            putExtra("destination", destination)
        }
        startActivity(intent)
    }

    fun onClickButtonProfileEdit(view: View) {
        val destination = "http://188.124.37.32:3001/dashboard/update"
        val intent = Intent(this, MainActivity::class.java).apply {
            // Отправляем destination в MainActivity
            putExtra("destination", destination)
        }
        startActivity(intent)
    }
}