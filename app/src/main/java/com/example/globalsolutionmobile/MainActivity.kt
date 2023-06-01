package com.example.globalsolutionmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val btnAbrir = findViewById<Button>(R.id.button5)

        btnAbrir.setOnClickListener{
            val i = Intent (this, MainActivity2::class.java)
            startActivity(i)

        }
    }
}