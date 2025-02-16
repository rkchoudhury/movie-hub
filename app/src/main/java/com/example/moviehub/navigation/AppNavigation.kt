package com.example.moviehub.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviehub.screens.dashboard.DashboardNavigator
import com.example.moviehub.screens.profile_selection.ProfileSelectionScreen
import com.example.moviehub.screens.view_all.ViewAllMovie

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.ProfileSelection.name) {
        composable(Route.ProfileSelection.name) { ProfileSelectionScreen(navController) }
        composable(Route.Dashboard.name) { DashboardNavigator(navController) }
        composable(Route.ViewAllMovie.name) { ViewAllMovie() }
    }
}