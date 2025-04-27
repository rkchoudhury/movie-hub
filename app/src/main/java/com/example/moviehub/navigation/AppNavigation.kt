package com.example.moviehub.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviehub.models.Movie
import com.example.moviehub.screens.dashboard.DashboardNavigator
import com.example.moviehub.screens.movie_details.MovieDetailsScreen
import com.example.moviehub.screens.profile_selection.ProfileSelectionScreen
import com.example.moviehub.screens.view_all.ViewAllMovie

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.Dashboard.name) {
        composable(Route.ProfileSelection.name) { ProfileSelectionScreen(navController) }
        composable(Route.Dashboard.name) { DashboardNavigator(navController) }
        composable(Route.ViewAllMovie.name) {
            val title =
                navController.previousBackStackEntry?.savedStateHandle?.get<String>("title") ?: ""
            val movieList =
                navController.previousBackStackEntry?.savedStateHandle?.get<List<Movie>>("movieList")
                    ?: emptyList()
            val movieType =
                navController.previousBackStackEntry?.savedStateHandle?.get<String>("movieType")
                    ?: ""
            ViewAllMovie(title, movieList, navController, movieType)
        }
        composable(Route.MovieDetails.name) { MovieDetailsScreen() }
    }
}