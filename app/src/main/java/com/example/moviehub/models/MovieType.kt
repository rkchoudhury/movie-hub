package com.example.moviehub.models

sealed class MovieType(val value: String) {
    data object NOW_PLAYING : MovieType("now_playing")
    data object POPULAR : MovieType("popular")
    data object TOP_RATED : MovieType("top_rated")
    data object UPCOMING : MovieType("upcoming")
}