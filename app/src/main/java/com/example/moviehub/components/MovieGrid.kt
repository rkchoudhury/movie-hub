package com.example.moviehub.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviehub.R
import com.example.moviehub.models.Movie

@Composable
fun MovieGrid(movieList: List<Movie>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3), modifier = Modifier
            .background(
                color = colorResource(
                    R.color.grey
                )
            )
            .padding(start = 20.dp, end = 20.dp, top = 10.dp)
    ) {
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