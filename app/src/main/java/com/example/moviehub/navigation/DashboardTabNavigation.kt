package com.example.moviehub.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviehub.screens.dashboard.HomeScreen
import com.example.moviehub.screens.dashboard.SearchScreen

@Composable
fun DashboardTabNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = DashboardTabItem.Home.route) {
        composable(DashboardTabItem.Home.route) {
            HomeScreen()
        }
        composable(DashboardTabItem.Search.route) {
            SearchScreen()
        }
    }
}