package com.example.cinemaniav3.model

data class MovieResponse(
    val results: List<Movie>
)

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String,
//    val release_date: String,
    val vote_average: Double
)