package com.yassinemoslah.movieguide.network.model

/**
 * Model class of a Movie
 */
data class Movie(
    var id: Int,
    var title: String,
    var year: String,
    var imageUrl: String,
    var description: String,
    var trailerUrl: String
)