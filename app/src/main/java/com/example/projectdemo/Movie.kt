package com.example.projectdemo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(

    @SerializedName("overview")
    val movieDesc: String?,

    @SerializedName("title")
    val title: String?,
//
    @SerializedName("vote_average")
    val ratings: Number,

    @SerializedName("poster_path")
    val poster: String?,

    @SerializedName("id")
    val id: Int,
//

    @SerializedName("genre_ids")
    val genres: Array<Int>,

    @SerializedName("status_message")
    val status: String?,

    @SerializedName("release_date")
    val release: String?,

    @SerializedName("original_language")
    val language: String?,

    @SerializedName("adult")
    val adult: Boolean,


    ) : Parcelable