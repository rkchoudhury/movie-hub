package com.example.moviehub.services

import com.example.moviehub.models.MovieResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

private const val BASE_URL = "https://api.themoviedb.org/3/movie/"

private const val TOKEN =
    "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1ZGFkMTIwMDRjMDdhMGQ4MjI0ZTk0ZGJmNDY4ZWJiZiIsInN1YiI6IjY1ZDk4YTZhOWQ4OTM5MDE2MmRhNzIyOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.36uJTAsCQUrvQw9SCgoVU3L8TqPRJRihp6xnAcgg6tg"

private val retrofit =
    Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

val movieService: MovieService = retrofit.create(MovieService::class.java)

interface MovieService {
    @Headers(
        "Accept: application/json",
        "Authorization: Bearer $TOKEN",
    )
    @GET("upcoming?language=en-US&page=1")
    suspend fun getPopularMovies(): MovieResponse

    @Headers(
        "Accept: application/json",
        "Authorization: Bearer $TOKEN",
    )
    @GET("{movie_type}?language=en-US&page=1")
    suspend fun getMovieBasedOnType(@Path("movie_type") type: String): MovieResponse

//    NOW_PLAYING = "now_playing",
//    POPULAR = "popular",
//    TOP_RATED = "top_rated",
//    UPCOMING = "upcoming",
}