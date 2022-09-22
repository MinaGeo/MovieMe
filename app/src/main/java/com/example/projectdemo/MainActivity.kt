package com.example.projectdemo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.edit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerapp.MovieAdapter
import com.google.android.material.switchmaterial.SwitchMaterial
import retrofit2.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var switch: SwitchMaterial
    private lateinit var loadingBar: ProgressBar
    private lateinit var waitPlease: TextView
    private lateinit var mySharedPreferences: SharedPreferences
    private lateinit var gridLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadingBar = findViewById(R.id.loading_bar)
        waitPlease = findViewById(R.id.waitPlease)
        switch = findViewById(R.id.switcher)
        recyclerView = findViewById(R.id.main_recycler_view)

        mySharedPreferences =
            getSharedPreferences("com_example_project_demo_SHARED_PREF", Context.MODE_PRIVATE)
        val spanCount = mySharedPreferences.getInt("Span_count", 2)

        if (spanCount == 2) switch.isChecked = true

        switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                setSpanCount(2)
            else
                setSpanCount(1)
        }

        gridLayoutManager = GridLayoutManager(this, spanCount)
        recyclerView.layoutManager = gridLayoutManager

        val backToChoose: Button = findViewById(R.id.backToCategory)
        backToChoose.setOnClickListener {
            val intent = Intent(this, CategoryChoose::class.java)

            startActivity(intent)
        }

        getMovieData { movies: List<Movie> ->
            val movieAdapter = MovieAdapter(movies)

            recyclerView.adapter = movieAdapter

            movieAdapter.onItemClick = {
                val intent = Intent(this, MovieDetailedActivity::class.java)

                intent.putExtra("Movie", it)

                startActivity(intent)
            }

        }

    }

    private fun getMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieService::class.java)
        apiService.getTopRatedMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                loadingBar.visibility = View.GONE
                waitPlease.visibility = View.GONE
                return callback(response.body()!!.movies)

            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d("FAIL", "onFailure: ")
            }
        })
    }

    private fun setSpanCount(spanCount: Int) {
        gridLayoutManager.spanCount = spanCount

        mySharedPreferences.edit {
            putInt("Span_count", spanCount)
            commit()

        }
    }
}