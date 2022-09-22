package com.example.projectdemo

import android.content.Context
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.recyclerapp.MovieAdapter
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detailed)
        val movie = intent.getParcelableExtra<Movie>("Movie")

        if (movie != null) {
            val ratings: TextView = findViewById(R.id.ratings)
            val textView: TextView = findViewById(R.id.detailedMovieLabel)
            val releaseDate: TextView = findViewById(R.id.dateReleased)
            val language: TextView = findViewById(R.id.language)
            val descView: TextView = findViewById(R.id.movieDescription)
            val adult: TextView = findViewById(R.id.adult)
            val back: Button = findViewById(R.id.back)
            val home: Button = findViewById(R.id.home)

            val moviePoster: ImageView = findViewById(R.id.detailedMoviePoster)
//            val genres: TextView = findViewById(R.id.genres)


            ratings.text= movie.ratings.toString()
            textView.text = movie.title
            descView.text = movie.movieDesc
            ratings.text = (movie.ratings.toFloat()).toString()
            releaseDate.text = (movie.release)?.substring(0, 4)
            language.text = movie.language

            back.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            home.setOnClickListener {
                val intent = Intent(this, CategoryChoose::class.java)
                startActivity(intent)
            }
            val media = "https://image.tmdb.org/t/p/w500/"
            Glide.with(this)
                .load(media + movie.poster)

                .into(moviePoster)

            if (movie.adult) {
                adult.text = "18+"
            }

            if (movie.language == "en") {
                language.text = "English"
            } else if (movie.language == "ja") {
                language.text = "Japanese"
            } else if (movie.language == "ko") {
                language.text = "Korean"
            } else if (movie.language == "te") {
                language.text = "Tamil"
            } else if (movie.language == "hi") {
                language.text = "Hindi"
            } else if (movie.language == "it") {
                language.text = "Italian"
            } else if (movie.language == "es") {
                language.text = "Spanish"

            }

        }

    }
}
