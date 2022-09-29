package com.example.projectdemo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MovieDetailedActivity : AppCompatActivity() {
    private lateinit var home: Button
    private lateinit var ratings: TextView
    private lateinit var textView: TextView
    private lateinit var releaseDate: TextView
    private lateinit var language: TextView
    private lateinit var descView: TextView
    private lateinit var adult: TextView
    private lateinit var back: Button
    private lateinit var moviePoster: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detailed)
        ratings = findViewById(R.id.ratings)
        textView = findViewById(R.id.detailedMovieLabel)
        releaseDate = findViewById(R.id.dateReleased)
        language = findViewById(R.id.language)
        descView = findViewById(R.id.movieDescription)
        adult = findViewById(R.id.adult)
        back = findViewById(R.id.back)
        moviePoster = findViewById(R.id.detailedMoviePoster)
        home = findViewById(R.id.home)

        val movie = intent.getParcelableExtra<Movie>("Movie")
        val popMovie = intent.getParcelableExtra<Movie>("PopMovie")
        val upcomingMovie = intent.getParcelableExtra<Movie>("UpcomingMovie")
        val popShows = intent.getParcelableExtra<Movie>("PopShows")
        val topShows = intent.getParcelableExtra<Movie>("TopShows")



        setMovie(movie)
        setMovie(popMovie)
        setMovie(upcomingMovie)
        setMovie(popShows)
        setMovie(topShows)



        if (upcomingMovie != null) {
            home.setOnClickListener {
                val intent = Intent(this, MovieCategoryChoose::class.java)
                startActivity(intent)
            }
            back.setOnClickListener {
                val intent = Intent(this, UpcomingMovies::class.java)
                startActivity(intent)
            }
        }
        if (popMovie != null) {
            home.setOnClickListener {
                val intent = Intent(this, MovieCategoryChoose::class.java)
                startActivity(intent)
            }
            back.setOnClickListener {
                val intent = Intent(this, PopularMovies::class.java)
                startActivity(intent)
            }
        }
        if (movie != null) {
            home.setOnClickListener {
                val intent = Intent(this, MovieCategoryChoose::class.java)
                startActivity(intent)
            }
            back.setOnClickListener {
                val intent = Intent(this, TopMovies::class.java)
                startActivity(intent)
            }
        }
        if (popShows != null) {
            textView.text = popShows.showName
            releaseDate.text = (popShows.showsDate)?.substring(0, 4)
            home.setOnClickListener {
                val intent = Intent(this, ShowsCategoryChoose::class.java)
                startActivity(intent)
            }
            back.setOnClickListener {
                val intent = Intent(this, PopularTvShows::class.java)
                startActivity(intent)
            }
        }
        if (topShows != null) {
            textView.text = topShows.showName
            releaseDate.text = (topShows.showsDate)?.substring(0, 4)
            home.setOnClickListener {
                val intent = Intent(this, ShowsCategoryChoose::class.java)
                startActivity(intent)
            }
            back.setOnClickListener {
                val intent = Intent(this, TopShows::class.java)
                startActivity(intent)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setMovie(movieType: Movie?) {
        if (movieType != null) {
            ratings.text = movieType.ratings.toString()
            textView.text = movieType.title
            descView.text = movieType.movieDesc
            ratings.text = (movieType.ratings.toFloat()).toString()
            releaseDate.text = (movieType.release)?.substring(0, 4)
            language.text = movieType.language

            val media = "https://image.tmdb.org/t/p/w500/"
            Glide.with(this)
                .load(media + movieType.poster)

                .into(moviePoster)

            if (movieType.adult) {
                adult.text = "18+"
            }

            if (movieType.language == "en") {
                language.text = "English"
            } else if (movieType.language == "ja") {
                language.text = "Japanese"
            } else if (movieType.language == "ko") {
                language.text = "Korean"
            } else if (movieType.language == "te") {
                language.text = "Tamil"
            } else if (movieType.language == "hi") {
                language.text = "Hindi"
            } else if (movieType.language == "it") {
                language.text = "Italian"
            } else if (movieType.language == "es") {
                language.text = "Spanish"

            }
        }
    }
}