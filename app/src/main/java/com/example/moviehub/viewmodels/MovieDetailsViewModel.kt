package com.example.moviehub.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviehub.models.MovieDetailsState
import com.example.moviehub.services.movieService
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val movie_id: Int): ViewModel() {
    private val _movieDetailsState = mutableStateOf(MovieDetailsState())
    private val movieDetailsState: State<MovieDetailsState> = _movieDetailsState

    init {
        fetchMovieDetails()
    }

    private fun fetchMovieDetails() {
        viewModelScope.launch {
            try {
                val result = movieService.getMovieDetails(movie_id);
                _movieDetailsState.value = _movieDetailsState.value.copy(
                    movieInfo = result.response,
                    loading = false,
                    error = null,
                )
                println("fetchMovieDetails response: ${_movieDetailsState.value}")
            } catch (e: Exception) {
                println("fetchMovies error: ${e.cause} - ${e.message}")
                _movieDetailsState.value = _movieDetailsState.value.copy(
                    loading = false,
                    error = "Error fetching movie details ${e.cause} - ${e.message}"
                )
            }
        }
    }
}