package com.example.moviehub.screens.dashboard

import android.annotation.SuppressLint
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.moviehub.components.BottomTabBar
import com.example.moviehub.navigation.DashboardTabNavigation
import com.example.moviehub.navigation.NavigationItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DashboardNavigator() {
    // Created a new Nav Controller for the Bottom Tab Navigator
    val navController = rememberNavController()

    val navigationItems = listOf(
        NavigationItem.Home,
        NavigationItem.Search,
    )

    Scaffold(
        bottomBar = {
            BottomAppBar(modifier = Modifier) {
                BottomTabBar(navController = navController, navigationItems = navigationItems)
            }
        },
    ) {
        DashboardTabNavigation(navController = navController)
    }
}