package com.example.moviehub.screens.view_all

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviehub.components.MovieGrid
import com.example.moviehub.components.NavigationBar
import com.example.moviehub.models.Movie

@Composable
fun ViewAllMovie(title: String, movieList: List<Movie>) {
    Column {
        NavigationBar(title = title)
        MovieGrid(movieList)
    }
}

@Preview
@Composable
fun ViewAllMoviePreview() {
    ViewAllMovie("", emptyList())
}