package com.example.moviehub.screens.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Search Screen", color = Color.White)
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}