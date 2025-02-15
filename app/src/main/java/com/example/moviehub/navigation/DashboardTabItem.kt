package com.example.moviehub.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DashboardTabItem(
    var route: String,
    val icon: ImageVector,
    var title: String
) {
    data object Home : DashboardTabItem(Route.Home.name, Icons.Rounded.Home, "Home")
    data object Search :
        DashboardTabItem(Route.Search.name, Icons.Rounded.Search, "Search")
}