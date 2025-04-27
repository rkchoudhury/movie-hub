package com.example.moviehub.screens.movie_details

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moviehub.components.NavigationBar
import com.example.moviehub.viewmodels.MovieDetailsViewModel

@Composable
fun MovieDetailsScreen(navController: NavController, movieId: Int, title: String) {
//    val movieDetailsViewModel: MovieDetailsViewModel = viewModel()
//    val movieDetailsState by movieDetailsViewModel.movieDetailsState

    Log.d("RKK", "MovieDetailsScreen: $movieId")

    Column {
        NavigationBar(title, navController)
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
    MovieDetailsScreen(navController, -1, "Good Days")
}