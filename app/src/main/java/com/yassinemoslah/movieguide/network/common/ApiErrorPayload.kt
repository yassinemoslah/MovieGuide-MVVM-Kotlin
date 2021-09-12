package com.yassinemoslah.movieguide.network.common

/**
 * Model class of an Api Error
 */
data class ApiErrorPayload(
    val statusCode: Int,
    val errorMessage: String
)