package com.example.moviehub.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviehub.models.Movie

@Composable
fun MovieGrid(movieList: List<Movie>) {
    val cardModifier = Modifier.padding(bottom = 10.dp, end = 10.dp)

    LazyVerticalGrid(
        columns = GridCells.Fixed(3), modifier = Modifier
            .padding(start = 20.dp, end = 10.dp, top = 10.dp)
    ) {
        items(movieList) { movie: Movie ->
            MovieCard(movie, cardModifier)
        }
    }
}

@Preview
@Composable
fun MovieGridPreview() {
    MovieGrid(emptyList())
}