package com.example.moviehub.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchScreen() {
    Column {
        Text(text = "Search Screen")
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}