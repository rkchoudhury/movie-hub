package com.example.moviehub.components

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviehub.R
import com.example.moviehub.models.Movie

@Composable
fun MovieList(movieList: List<Movie>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Popular Movies",
            color = colorResource(R.color.gold),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Left,
        )
        LazyRow(modifier = Modifier.padding(0.dp, 25.dp, 0.dp, 0.dp)) {
            items(movieList) { movie ->
                MovieCard(movie)
            }
        }
    }
}

@Preview
@Composable
fun MovieListPreview() {
    MovieList(emptyList())
}