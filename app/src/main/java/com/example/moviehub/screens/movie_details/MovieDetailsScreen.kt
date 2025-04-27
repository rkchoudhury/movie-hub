package com.example.moviehub.screens.movie_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moviehub.components.NavigationBar

@Composable
fun MovieDetailsScreen(navController: NavController) {
    Column {
        NavigationBar(title = "", navController)
        Text(
            text = "Movie Details",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun MovieDetailsScreenPreview() {
    val navController = rememberNavController()
    MovieDetailsScreen(navController)
}