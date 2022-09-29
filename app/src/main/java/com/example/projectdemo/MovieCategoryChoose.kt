package com.example.projectdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MovieCategoryChoose : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_category_choose)

        val topRatedButton: Button = findViewById(R.id.topRatedMovies)
        val popularButton: Button = findViewById(R.id.popularMovies)
        val upcomingButton: Button = findViewById(R.id.upcomingMovies)
        val back: Button = findViewById(R.id.backToCategory)

        back.setOnClickListener {
            val intent = Intent(this, MovieorTv::class.java)

            startActivity(intent)
        }
        upcomingButton.setOnClickListener {
            val intent = Intent(this, UpcomingMovies::class.java)

            startActivity(intent)
        }
        topRatedButton.setOnClickListener {
            val intent = Intent(this, TopMovies::class.java)

            startActivity(intent)
        }

        popularButton.setOnClickListener {
            val intent = Intent(this, PopularMovies::class.java)

            startActivity(intent)
        }
    }
}