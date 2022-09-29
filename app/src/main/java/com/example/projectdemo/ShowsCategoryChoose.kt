package com.example.projectdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ShowsCategoryChoose : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shows_cateogry_choose)

        val topRatedTVButton: Button = findViewById(R.id.topRatedShows)
        val popularTVButton: Button = findViewById(R.id.popularShows)
        val back: Button = findViewById(R.id.backToCategory)

back.setOnClickListener {
    val intent = Intent(this, MovieorTv::class.java)

    startActivity(intent)
}

        topRatedTVButton.setOnClickListener {
            val intent = Intent(this, TopShows::class.java)

            startActivity(intent)
        }

        popularTVButton.setOnClickListener {
            val intent = Intent(this, PopularTvShows::class.java)

            startActivity(intent)
        }
    }
}