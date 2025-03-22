package com.example.moviehub.screens.view_all

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moviehub.R
import com.example.moviehub.components.MovieGrid
import com.example.moviehub.components.NavigationBar
import com.example.moviehub.factory.MoreMovieViewModelFactory
import com.example.moviehub.models.Movie
import com.example.moviehub.models.MovieState
import com.example.moviehub.models.MovieType
import com.example.moviehub.viewmodels.MoreMovieViewModel

@Composable
fun ViewAllMovie(
    title: String,
    movieList: List<Movie>,
    navController: NavController,
    movieType: String
) {
    val moreMovieViewModel: MoreMovieViewModel = viewModel(
        factory = MoreMovieViewModelFactory(movieList)
    )
    val moreMoviesState = moreMovieViewModel.moreMoviesState.value

    Column {
        NavigationBar(title = "$title Movies", navController)
        MovieGrid(moreMoviesState.list) {
            LoadMoreCard(moreMoviesState, moreMovieViewModel, movieType)
        }
    }
}

@Composable
fun LoadMoreCard(moreMoviesState: MovieState, moreMovieViewModel: MoreMovieViewModel, movieType: String) {
    Column(
        modifier = Modifier
            .width(125.dp)
            .height(177.dp)
            .border(
                width = 1.dp,
                color = colorResource(R.color.gold),
                shape = RoundedCornerShape(5.dp)
            )
            .clickable {
                if (!moreMoviesState.loading) {
                    moreMovieViewModel.fetchMoreMovies(movieType)
                }
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = if (moreMoviesState.loading) "Loading..." else "Load More",
            color = colorResource(R.color.gold),
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun ViewAllMoviePreview() {
    val navController = rememberNavController()
    ViewAllMovie("Movie", emptyList(), navController, MovieType.POPULAR.value)
}