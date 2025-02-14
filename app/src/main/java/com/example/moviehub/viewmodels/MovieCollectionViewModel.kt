package com.example.moviehub.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviehub.models.MovieState
import com.example.moviehub.models.MovieType
import com.example.moviehub.services.movieService
import kotlinx.coroutines.launch

class MovieCollectionViewModel : ViewModel() {
    private val _upcomingMoviesState = mutableStateOf(MovieState(categoryTitle = "Upcoming"))
    private val _nowPlayingMoviesState = mutableStateOf(MovieState(categoryTitle = "Now Playing"))
    private val _topRatedMoviesState = mutableStateOf(MovieState(categoryTitle = "Top Rated"))

    // This is the public variable which can be accessed from the outside
    val upcomingMoviesState: State<MovieState> = _upcomingMoviesState
    val nowPlayingMoviesState: State<MovieState> = _nowPlayingMoviesState
    val topRatedMoviesState: State<MovieState> = _topRatedMoviesState

    // On object creation we are fetching the categories
    init {
        fetchUpcomingMovies()
        fetchNowPlayingMovies()
        fetchTopRatedMovies()
    }

    private fun fetchUpcomingMovies() {
        viewModelScope.launch {
            try {
                val response =
                    movieService.getMovieBasedOnType(type = MovieType.UPCOMING.value)
                _upcomingMoviesState.value = _upcomingMoviesState.value.copy(
                    list = response.results,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                println("fetchMovies error: ${e.cause} - ${e.message}")
                _upcomingMoviesState.value = _upcomingMoviesState.value.copy(
                    loading = false,
                    error = "Error fetching categories ${e.cause} - ${e.message}"
                )
            }
        }
    }

    private fun fetchNowPlayingMovies() {
        viewModelScope.launch {
            try {
                val response =
                    movieService.getMovieBasedOnType(type = MovieType.NOW_PLAYING.value)
                _nowPlayingMoviesState.value = _nowPlayingMoviesState.value.copy(
                    list = response.results,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                println("fetchMovies error: ${e.cause} - ${e.message}")
                _nowPlayingMoviesState.value = _nowPlayingMoviesState.value.copy(
                    loading = false,
                    error = "Error fetching categories ${e.cause} - ${e.message}"
                )
            }
        }
    }

    private fun fetchTopRatedMovies() {
        viewModelScope.launch {
            try {
                val response =
                    movieService.getMovieBasedOnType(type = MovieType.TOP_RATED.value)
                _topRatedMoviesState.value = _topRatedMoviesState.value.copy(
                    list = response.results,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                println("fetchMovies error: ${e.cause} - ${e.message}")
                _topRatedMoviesState.value = _topRatedMoviesState.value.copy(
                    loading = false,
                    error = "Error fetching categories ${e.cause} - ${e.message}"
                )
            }
        }
    }
}