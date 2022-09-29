package com.example.projectdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MovieorTv : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movieor_tv)

        val movies: Button = findViewById(R.id.Movies)
        val tvShows: Button = findViewById(R.id.TvShows)

        movies.setOnClickListener {
            val intent = Intent(this, MovieCategoryChoose::class.java)

            startActivity(intent)
        }
        tvShows.setOnClickListener {
            val intent = Intent(this, ShowsCategoryChoose::class.java)

            startActivity(intent)
        }


    }
}