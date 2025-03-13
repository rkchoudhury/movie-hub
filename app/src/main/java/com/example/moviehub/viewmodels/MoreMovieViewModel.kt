package com.example.moviehub.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviehub.models.MovieState
import com.example.moviehub.models.MovieType
import com.example.moviehub.services.movieService
import kotlinx.coroutines.launch

class MoreMovieViewModel: ViewModel() {
    private val _moreMoviesState = mutableStateOf(MovieState(categoryTitle = "", loading = false))

    val moreMoviesState: State<MovieState> = _moreMoviesState

   fun fetchMoreMovies() {
        viewModelScope.launch {
            try {
                _moreMoviesState.value = _moreMoviesState.value.copy(
                    loading = true,
                )
                val response =
                    movieService.getMoreMovies(type = MovieType.TOP_RATED.value, page = 2)
                _moreMoviesState.value = _moreMoviesState.value.copy(
                    list = response.results,
                    loading = false,
                    error = null
                )
                println("fetchMoreMovies response: ${_moreMoviesState.value}")
            } catch (e: Exception) {
                println("fetchMoreMovies error: ${e.cause} - ${e.message}")
                _moreMoviesState.value = _moreMoviesState.value.copy(
                    loading = false,
                    error = "Error fetching more movies ${e.cause} - ${e.message}"
                )
            }
        }
    }
}