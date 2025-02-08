package com.example.moviehub.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(var route: String, val icon: ImageVector, var title: String) {
    data object Home : NavigationItem(Route.Home.name, Icons.Rounded.Home, "Home")
    data object Search : NavigationItem(Route.Search.name, Icons.AutoMirrored.Rounded.List, "Search")
}