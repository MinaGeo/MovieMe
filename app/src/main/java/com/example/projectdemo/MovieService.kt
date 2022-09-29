package com.example.projectdemo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("/3/movie/top_rated?api_key=ee1155bec12e874f464b316a1784f3c8")
    fun getTopRatedMovieList(): Call<MovieResponse>

    @GET("/3/movie/popular?api_key=ee1155bec12e874f464b316a1784f3c8")
    fun getPopularMovieList(): Call<MovieResponse>

    @GET("/3/movie/upcoming?api_key=ee1155bec12e874f464b316a1784f3c8")
    fun getUpcomingMovieList(): Call<MovieResponse>

    @GET("/3/movie/{movie_id}?api_key=ee1155bec12e874f464b316a1784f3c8")
    fun getMovieGenre(@Path("movie_id") movie_id: Int): Call<Movie>
}

