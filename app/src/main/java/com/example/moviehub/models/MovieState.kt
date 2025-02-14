package com.example.moviehub.models

// This is the structure of our state to which we will update the value
data class MovieState(
    val list: List<Movie> = emptyList(),
    val loading: Boolean = true,
    val error: String? = null
)