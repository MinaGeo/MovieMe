package com.example.projectdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CategoryChoose : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_choose)


        val text: TextView = findViewById(R.id.textChoose)
        val topRatedButton: Button = findViewById(R.id.topRated)
        val popularButton: Button = findViewById(R.id.popular)

        topRatedButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }

        popularButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            startActivity(intent)
        }
    }
}