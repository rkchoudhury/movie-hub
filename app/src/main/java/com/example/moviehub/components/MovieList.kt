package com.example.moviehub.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviehub.R
import com.example.moviehub.models.Movie

@Composable
fun MovieList(movieList: List<Movie>, loading: Boolean, error: String?) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Popular Movies",
            color = colorResource(R.color.gold),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 5.dp, start = 10.dp),
            textAlign = TextAlign.Left,
        )
        MovieRow(movieList, loading, error)
    }
}

@Composable
fun MovieRow(movieList: List<Movie>, loading: Boolean, error: String?) {
    when {
        loading -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }
        }

        error != null -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Something went wrong", color = Color.Red)
            }
        }

        else -> {
            LazyRow {
                items(movieList) { movie ->
                    MovieCard(movie)
                }
            }
        }
    }
}

@Preview
@Composable
fun MovieListPreview() {
    MovieList(emptyList(), true, null)
}