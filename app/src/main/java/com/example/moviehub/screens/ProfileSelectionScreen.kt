package com.example.moviehub.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProfileSelectionScreen(navController: NavController) {
    Column {
        Text(text = "Choose a profile to begin")
        Button(onClick = { navController.navigate(route = "Home") }) {
            Text(text = "Home")
        }
    }
}

@Preview
@Composable
fun ProfileSelectionScreenPreview() {
    val navController = rememberNavController()
    ProfileSelectionScreen(navController)
}
