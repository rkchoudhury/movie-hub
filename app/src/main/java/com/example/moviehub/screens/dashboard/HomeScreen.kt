package com.example.moviehub.screens.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.moviehub.components.MovieList
import com.example.moviehub.components.MoviePreviewCard
import com.example.moviehub.models.MovieState
import com.example.moviehub.viewmodels.MovieCollectionViewModel
import com.example.moviehub.viewmodels.MovieViewModel
import kotlin.random.Random

@Composable
fun HomeScreen(navController: NavHostController?) {
    val movieViewModel: MovieViewModel = viewModel()
    val movieCollectionViewModel: MovieCollectionViewModel = viewModel()
    val popularMovieState by movieViewModel.moviesState
    val upcomingMoviesState by movieCollectionViewModel.upcomingMoviesState
    val topRatedMoviesState by movieCollectionViewModel.topRatedMoviesState
    val nowPlayingMoviesState by movieCollectionViewModel.nowPlayingMoviesState
    var latestMovieIndex by rememberSaveable { mutableIntStateOf(-1) }

    if (nowPlayingMoviesState.list.isNotEmpty() && latestMovieIndex == -1) {
        val randomIndex = Random.nextInt(nowPlayingMoviesState.list.size)
        latestMovieIndex = randomIndex
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (latestMovieIndex != -1) {
            val latestMovie = nowPlayingMoviesState.list[latestMovieIndex]
            MoviePreviewCard(latestMovie)
        }
        LazyColumn {
            items(
                listOf<MovieState>(
                    nowPlayingMoviesState,
                    popularMovieState,
                    topRatedMoviesState,
                    upcomingMoviesState,
                )
            ) { item ->
                val (list, loading, error, categoryTitle, type) = item
                MovieList(list, loading, error, categoryTitle, navController, type)
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(null)
}