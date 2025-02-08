package com.example.moviehub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.moviehub.navigation.AppNavigation
import com.example.moviehub.ui.theme.MovieHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieHubTheme {
                AppNavigation()
            }
        }
    }
}