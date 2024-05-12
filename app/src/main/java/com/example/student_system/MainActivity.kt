package com.example.student_system

import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val destination = intent.getStringExtra("destination")
        if (destination != null) {
            webViewInit(destination)
        }
    }

    fun onClickButtonBack(view: View) {
        this.finish()
    }

    fun webViewInit(destination: String) {
        System.out.println("Aboba")
        // Инициализация WebView
        val webView = findViewById<WebView>(R.id.mainActivityWebView)

        // Активируем JS
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // Подгружаем страницу
        webView.loadUrl(destination)

        // Отступы для системных панелей
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
