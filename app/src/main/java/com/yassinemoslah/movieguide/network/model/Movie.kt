package com.yassinemoslah.movieguide.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(var id: Int, var title: String?, var year: String?, var image: String?, var description: String?, var trailerUrl: String?) : Parcelable