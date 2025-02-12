package com.example.moviehub.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.moviehub.R
import com.example.moviehub.models.Movie

@Composable
fun MovieCard(movie: Movie) {
    val CDN_IMAGE_URL = "https://image.tmdb.org/t/p/w500/"

    Column(
        modifier = Modifier
            .padding(start = 10.dp)
            .width(100.dp)
            .background(color = colorResource(R.color.grey_two)),
        horizontalAlignment = Alignment.Start,
    ) {
        Image(
            painter = rememberAsyncImagePainter(CDN_IMAGE_URL + movie.poster_path),
            contentDescription = movie.original_title,
            alignment = Alignment.TopStart,
            modifier = Modifier
                .height(150.dp)
                .width(100.dp),
            contentScale = ContentScale.FillHeight
        )
        Text(
            text = movie.title,
            color = colorResource(R.color.gold),
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 1.dp),
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview()
@Composable
fun MovieCardPreview() {
    val movie = Movie(
        adult = false,
        backdrop_path = "/kEYWal656zP5Q2Tohm91aw6orlT.jpg",
        genre_ids = listOf(18, 35, 10749),
        id = 1064213,
        original_language = "en",
        original_title = "Anora",
        overview = "A young sex worker from Brooklyn gets her chance at a Cinderella story when she meets and impulsively marries the son of an oligarch. Once the news reaches Russia, her fairytale is threatened as his parents set out to get the marriage annulled.",
        popularity = 530.515,
        poster_path = "/7MrgIUeq0DD2iF7GR6wqJfYZNeC.jpg",
        release_date = "2024-10-14",
        title = "Anora",
        video = false,
        vote_average = 7.1,
        vote_count = 960
    )

    MovieCard(movie)
}