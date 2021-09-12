package com.yassinemoslah.movieguide.data.common

/**
 * Model class of an Api Error
 */
data class ApiErrorPayload(
    val statusCode: Int,
    val errorMessage: String
)