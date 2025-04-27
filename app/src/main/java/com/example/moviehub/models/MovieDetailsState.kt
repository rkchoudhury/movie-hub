package com.example.moviehub.models

data class MovieDetailsState (
    val movieInfo: MovieInfo? = null,
    val loading: Boolean = true,
    val error: String? = null,
)