package com.example.moviehub.screens.dashboard

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.moviehub.components.BottomTabBar
import com.example.moviehub.navigation.DashboardTabItem
import com.example.moviehub.navigation.DashboardTabNavigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DashboardNavigator() {
    // Created a new Nav Controller for the Bottom Tab Navigator
    val navController = rememberNavController()

    val navigationItems = listOf(
        DashboardTabItem.Home,
        DashboardTabItem.Search,
    )

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(50.dp),
                contentPadding = PaddingValues(0.dp),
            ) {
                BottomTabBar(
                    navController = navController,
                    navigationItems = navigationItems,
                )
            }
        },
    ) { innerPadding ->
        Box(modifier = Modifier.padding(PaddingValues(bottom = innerPadding.calculateBottomPadding()))) {
            DashboardTabNavigation(navController = navController)
        }
    }
}