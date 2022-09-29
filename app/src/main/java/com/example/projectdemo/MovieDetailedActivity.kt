package com.example.projectdemo

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
//            val fav: Button = findViewById(R.id.favorite)

        val movie = intent.getParcelableExtra<Movie>("Movie")
        val topMovie = intent.getParcelableExtra<Movie>("TopMovie")
        val upcomingMovie = intent.getParcelableExtra<Movie>("UpcomingMovie")

        setMovie(movie)
        setMovie(topMovie)
        setMovie(upcomingMovie)

        if (upcomingMovie != null) {
            back.setOnClickListener {
                val intent = Intent(this, UpcomingMovies::class.java)
                startActivity(intent)
            }
        }
        if (topMovie != null) {
            back.setOnClickListener {
                val intent = Intent(this, PopularMovies::class.java)
                startActivity(intent)
            }
        }
        if (movie != null) {
            back.setOnClickListener {
                val intent = Intent(this, TopMovies::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setMovie(movieType: Movie?) {
        if (movieType != null) {
            ratings.text = movieType.ratings.toString()
            textView.text = movieType.title
            descView.text = movieType.movieDesc
            ratings.text = (movieType.ratings.toFloat()).toString()
            releaseDate.text = (movieType.release)?.substring(0, 4)
            language.text = movieType.language
//fav.setOnClickListener {
//    fav.setBackgroundColor(Color.parseColor("#e52165"))
//}
            home.setOnClickListener {
                val intent = Intent(this, CategoryChoose::class.java)
                startActivity(intent)
            }
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