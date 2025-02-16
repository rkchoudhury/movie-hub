package com.example.moviehub.screens.view_all

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviehub.components.MovieGrid
import com.example.moviehub.models.Movie

@Composable
fun ViewAllMovie(title: String, movieList: List<Movie>) {
    Column {
        Text(text = "View All Movie $title")
        MovieGrid(movieList)
    }
}

@Preview
@Composable
fun ViewAllMoviePreview() {
    ViewAllMovie("", emptyList())
}