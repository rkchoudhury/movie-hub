package com.example.moviehub.models

data class MovieDetails(
    val adult: Boolean,
    val backdrop_path: String,
    val budget: Double,
    val genres: List<Genres>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int,
    val revenue: Double,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage>,
    val production_countries: List<ProductionCountry>,
    val production_companies: List<ProductionCompany>,
)

data class Genres(
    val id: Int,
    val name: String
)

data class SpokenLanguage(
    val english_name: String,
    val iso_639_1: String,
    val name: String,
)

data class ProductionCountry(
    val iso_3166_1: String,
    val name: String,
)

data class ProductionCompany(
    val id: Int,
    val logo_path: String,
    val name: String,
    val origin_country: String,
)