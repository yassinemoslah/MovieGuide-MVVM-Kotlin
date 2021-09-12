package com.yassinemoslah.movieguide.network.model

import com.google.gson.annotations.SerializedName

/**
 * Model class of a Category
 */
data class Category(
    @SerializedName("categoryName") val name: String
)