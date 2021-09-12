package com.yassinemoslah.movieguide.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Model class of a Movie
 */
@Parcelize
data class Movie(
    var id: Int,
    var title: String,
    var year: String,
    var imageUrl: String,
    var description: String,
    var trailerUrl: String
) : Parcelable