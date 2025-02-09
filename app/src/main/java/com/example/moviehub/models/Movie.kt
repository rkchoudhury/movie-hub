package com.example.moviehub.models

data class Movie(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Number>,
    val id: Number,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Number,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Number,
    val vote_count: String,
)

data class MovieResponse(
    val results: List<Movie>
)