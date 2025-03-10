package com.example.moviehub.screens.view_all

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moviehub.components.MovieGrid
import com.example.moviehub.components.NavigationBar
import com.example.moviehub.models.Movie

@Composable
fun ViewAllMovie(title: String, movieList: List<Movie>, navController: NavController) {
    Column {
        NavigationBar(title = title, navController)
        MovieGrid(movieList)
    }
}

@Preview
@Composable
fun ViewAllMoviePreview() {
    val navController = rememberNavController()
    ViewAllMovie("Movie", emptyList(), navController)
}