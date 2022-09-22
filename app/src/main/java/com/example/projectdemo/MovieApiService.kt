package com.example.projectdemo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApiService {
    companion object {
        private var retrofit: Retrofit? = null

        fun getInstance(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}