package com.example.moviehub.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviehub.models.Movie
import com.example.moviehub.viewmodels.MoreMovieViewModel

class MoreMovieViewModelFactory(private val movies: List<Movie>) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoreMovieViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MoreMovieViewModel(movies) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
