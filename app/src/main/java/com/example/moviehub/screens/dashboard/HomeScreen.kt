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
import com.example.moviehub.models.MovieState
import com.example.moviehub.viewmodels.MovieCollectionViewModel
import com.example.moviehub.viewmodels.MovieViewModel

@Composable
fun HomeScreen() {
    val movieViewModel: MovieViewModel = viewModel()
    val movieCollectionViewModel: MovieCollectionViewModel = viewModel()
    val popularMovieState by movieViewModel.moviesState
    val upcomingMoviesState by movieCollectionViewModel.upcomingMoviesState
    val topRatedMoviesState by movieCollectionViewModel.topRatedMoviesState
    val nowPlayingMoviesState by movieCollectionViewModel.nowPlayingMoviesState

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.grey))
    ) {
        LazyColumn {
            items(
                listOf<MovieState>(
                    upcomingMoviesState,
                    popularMovieState,
                    nowPlayingMoviesState,
                    topRatedMoviesState
                )
            ) { item ->
                MovieList(item.list, item.loading, item.error, item.categoryTitle)
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}