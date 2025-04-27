package com.example.moviehub.models

data class MovieDetailsState (
    val movieDetails: MovieDetails? = null,
    val loading: Boolean = true,
    val error: String? = null,
)