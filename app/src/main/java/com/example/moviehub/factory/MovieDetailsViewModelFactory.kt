package com.example.moviehub.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviehub.viewmodels.MovieDetailsViewModel

/**
 * @method: MovieDetailsViewModelFactory
 * @description: This Factory method is used to pass the movieId value from the View layer to ViewModel
 * @param movieId: Movie Id that needs to pass from the View to MovieDetailsViewModel
 */
class MovieDetailsViewModelFactory(private val movieId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieDetailsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MovieDetailsViewModel(movieId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}