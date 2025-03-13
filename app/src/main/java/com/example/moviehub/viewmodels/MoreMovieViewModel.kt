package com.example.moviehub.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviehub.models.Movie
import com.example.moviehub.models.MovieState
import com.example.moviehub.models.MovieType
import com.example.moviehub.services.movieService
import kotlinx.coroutines.launch

class MoreMovieViewModel(private val movies: List<Movie>) : ViewModel() {
    private val _moreMoviesState =
        mutableStateOf(MovieState(list = movies, categoryTitle = "", loading = false))
    private val _pageCount = mutableIntStateOf(2)

    val moreMoviesState: State<MovieState> = _moreMoviesState

    fun fetchMoreMovies() {
        viewModelScope.launch {
            try {
                println("fetchMoreMovies for page: ${_pageCount.intValue}")
                _moreMoviesState.value = _moreMoviesState.value.copy(
                    loading = true,
                )
                val response =
                    movieService.getMoreMovies(
                        type = MovieType.TOP_RATED.value,
                        page = _pageCount.intValue
                    )
                val allMovies = _moreMoviesState.value.list + response.results

                _moreMoviesState.value = _moreMoviesState.value.copy(
                    list = allMovies,
                    loading = false,
                    error = null
                )
                println("fetchMoreMovies response: ${_moreMoviesState.value}")
                _pageCount.value += 1
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