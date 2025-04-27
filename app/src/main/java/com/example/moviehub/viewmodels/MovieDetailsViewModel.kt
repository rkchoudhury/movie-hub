package com.example.moviehub.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviehub.models.MovieDetailsState
import com.example.moviehub.services.movieService
import kotlinx.coroutines.launch

class MovieDetailsViewModel(): ViewModel() {
    private val _movieDetailsState = mutableStateOf(MovieDetailsState())
    val movieDetailsState: State<MovieDetailsState> = _movieDetailsState
    private val movieId: Int = 950387

    init {
        fetchMovieDetails()
    }

    private fun fetchMovieDetails() {
        viewModelScope.launch {
            try {
                val response = movieService.getMovieDetails(movieId = 950387);
                println("fetchMovieDetails response: $response")
                _movieDetailsState.value = _movieDetailsState.value.copy(
                    movieInfo = response,
                    loading = false,
                    error = null,
                )
            } catch (e: Exception) {
                println("fetchMovieDetails error: ${e.cause} - ${e.message}")
                _movieDetailsState.value = _movieDetailsState.value.copy(
                    loading = false,
                    error = "Error fetching movie details ${e.cause} - ${e.message}"
                )
            }
        }
    }
}