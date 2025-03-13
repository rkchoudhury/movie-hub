package com.example.moviehub.screens.view_all

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moviehub.components.MovieGrid
import com.example.moviehub.components.NavigationBar
import com.example.moviehub.models.Movie
import com.example.moviehub.viewmodels.MoreMovieViewModel

@Composable
fun ViewAllMovie(title: String, movieList: List<Movie>, navController: NavController) {
    val moreMovieViewModel: MoreMovieViewModel = viewModel()
    val moreMoviesState = moreMovieViewModel.moreMoviesState.value

    Column {
        NavigationBar(title = "$title Movies", navController)
        Button(
            onClick = {
                if (!moreMoviesState.loading) {
                    moreMovieViewModel.fetchMoreMovies()
                }
            },
//            enabled = !moreMoviesState.loading
        ) {
            Text(text = if (moreMoviesState.loading) "Loading..." else "Load More")
            Text(text = "  ${moreMoviesState.list.size}")
        }
        MovieGrid(movieList)
    }
}

@Preview
@Composable
fun ViewAllMoviePreview() {
    val navController = rememberNavController()
    ViewAllMovie("Movie", emptyList(), navController)
}