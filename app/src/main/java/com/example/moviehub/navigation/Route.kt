package com.example.moviehub.navigation

sealed class Route(val name: String) {
    data object ProfileSelection: Route("ProfileSelection")
    data object Dashboard: Route("Dashboard")
    data object Home: Route("Home")
    data object Search: Route("Search")
    data object ViewAllMovie: Route("ViewAllMovie")
}