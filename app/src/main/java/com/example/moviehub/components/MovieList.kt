package com.example.moviehub.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.moviehub.R
import com.example.moviehub.models.Movie
import com.example.moviehub.models.MovieType
import com.example.moviehub.navigation.Route

@Composable
fun MovieList(
    movieList: List<Movie>,
    loading: Boolean,
    error: String?,
    title: String,
    navController: NavHostController?,
    movieType: String,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        MovieListHeader(title, navController, movieList, movieType)
        MovieRow(movieList, loading, error, navController)
    }
}

@Composable
fun MovieListHeader(
    title: String,
    navController: NavHostController?,
    movieList: List<Movie>,
    movieType: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 5.dp, start = 10.dp, end = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = title,
            color = colorResource(R.color.gold),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )
        Text(
            text = "View All",
            color = colorResource(R.color.gold),
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            modifier = Modifier.clickable {
                navController!!.currentBackStackEntry?.savedStateHandle?.set("title", title)
                navController.currentBackStackEntry?.savedStateHandle?.set("movieList", movieList)
                navController.currentBackStackEntry?.savedStateHandle?.set("movieType", movieType)
                navController.navigate(Route.ViewAllMovie.name)
            }
        )
    }
}

@Composable
fun MovieRow(
    movieList: List<Movie>,
    loading: Boolean,
    error: String?,
    navController: NavHostController?
) {
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
            val cardModifier = Modifier.padding(start = 10.dp)
            LazyRow {
                items(movieList) { movie ->
                    MovieCard(movie, cardModifier, navController)
                }
            }
        }
    }
}

@Preview
@Composable
fun MovieListPreview() {
    MovieList(emptyList(), true, null, "", null, MovieType.POPULAR.value)
}