package com.example.moviedbgoogle.network

import com.squareup.moshi.Json

data class MovieResponse(
    val results: List<Movie>) {

    data class Movie(
        //val id: Int,
        val title: String,
        @Json(name = "poster_path")
        val imgSrcUrl: String,
    )
}