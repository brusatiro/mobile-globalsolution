package com.example.globalsolutionmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main3)

        val btnVoltar = findViewById<Button>(R.id.button5)

        btnVoltar.setOnClickListener{
            val i = Intent (this, MapsActivity::class.java)
            startActivity(i)

        }
    }
}