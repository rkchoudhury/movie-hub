package com.example.moviehub.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.moviehub.R
import com.example.moviehub.navigation.DashboardTabItem

@Composable
fun BottomTabBar(
    navController: NavController,
    navigationItems: List<DashboardTabItem>,
) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    NavigationBar(
        containerColor = colorResource(R.color.grey),
    ) {
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                alwaysShowLabel = false,
                icon = { Icon(item.icon, contentDescription = item.title) },
                selected = item.route == backStackEntry.value?.destination?.route,
                colors = NavigationBarItemColors(
                    selectedIconColor = colorResource(R.color.gold),
                    selectedTextColor = colorResource(R.color.gold),
                    unselectedIconColor = colorResource(R.color.white_two),
                    unselectedTextColor = colorResource(R.color.white_two),
                    selectedIndicatorColor = colorResource(R.color.grey),
                    disabledIconColor = colorResource(R.color.grey_two),
                    disabledTextColor = colorResource(R.color.grey_two)
                ),
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}