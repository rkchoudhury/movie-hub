package com.example.moviehub.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.moviehub.models.Movie

@Composable
fun MoviePreviewCard(movie: Movie) {
    val CDN_IMAGE_URL = "https://image.tmdb.org/t/p/w500/"

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .padding(top = 10.dp, bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .weight(1f)
                .clip(
                    RoundedCornerShape(
                        topStart = 5.dp,
                        topEnd = 5.dp,
                        bottomStart = 5.dp,
                        bottomEnd = 5.dp
                    )
                )
                .border(
                    width = 1.dp,
                    shape = RoundedCornerShape(
                        topStart = 5.dp,
                        topEnd = 5.dp,
                        bottomStart = 5.dp,
                        bottomEnd = 5.dp
                    ),
                    color = Color.Red
                ),
            painter = rememberAsyncImagePainter("$CDN_IMAGE_URL${movie.poster_path}"),
            contentDescription = movie.original_title,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(10.dp))
        IconButton(label = "Play", icon = Icons.Rounded.PlayArrow, onPress = {})
    }
}

@Preview(showSystemUi = true)
@Composable
fun MoviePreviewCardPreview() {
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

    MoviePreviewCard(movie)
}