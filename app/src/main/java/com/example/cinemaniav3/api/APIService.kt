package com.example.cinemaniav3.api

import com.example.cinemaniav3.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("movie/top_rated")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "en-US"
    ): MovieResponse
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "en-US"
    ): MovieResponse
}