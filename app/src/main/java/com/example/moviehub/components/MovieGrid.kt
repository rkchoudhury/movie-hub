package com.example.moviehub.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviehub.models.Movie

@Composable
fun MovieGrid(movieList: List<Movie>) {
    LazyColumn {
        items(movieList) { movie: Movie ->
            MovieCard(movie)
        }
    }
}

@Preview
@Composable
fun MovieGridPreview() {
    MovieGrid(emptyList())
}