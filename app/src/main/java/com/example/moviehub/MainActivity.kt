package com.example.moviehub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import com.example.moviehub.screens.HomeScreen
import com.example.moviehub.screens.ProfileSelectionScreen
import com.example.moviehub.screens.SearchScreen
import com.example.moviehub.ui.theme.MovieHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieHubTheme {
                Column {
                    ProfileSelectionScreen()
                    HomeScreen()
                    SearchScreen()
                }
            }
        }
    }
}