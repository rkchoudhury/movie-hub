package com.example.moviehub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviehub.navigation.Route
import com.example.moviehub.screens.dashboard.DashboardNavigator
import com.example.moviehub.screens.profile_selection.ProfileSelectionScreen
import com.example.moviehub.ui.theme.MovieHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieHubTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.ProfileSelection.name) {
        composable(Route.ProfileSelection.name) { ProfileSelectionScreen(navController) }
        composable(Route.Dashboard.name) { DashboardNavigator() }
    }
}