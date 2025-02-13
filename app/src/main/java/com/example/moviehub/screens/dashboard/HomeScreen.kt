package com.example.moviehub.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moviehub.R
import com.example.moviehub.components.MovieList
import com.example.moviehub.viewmodels.MovieViewModel

@Composable
fun HomeScreen() {
    val movieViewModel: MovieViewModel = viewModel()
    val viewState by movieViewModel.moviesState

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.grey))
    ) {
        LazyColumn {
            items(listOf(1, 2, 3, 4)) { item ->
                MovieList(viewState.list, viewState.loading, viewState.error)
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}