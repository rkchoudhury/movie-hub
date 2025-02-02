package com.example.moviehub.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfileSelectionScreen() {
    Column {
       Text(text = "Choose a profile to begin")
    }
}

@Preview
@Composable
fun ProfileSelectionScreenPreview() {
    ProfileSelectionScreen()
}
