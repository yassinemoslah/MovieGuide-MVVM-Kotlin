package com.yassinemoslah.movieguide.network.adapter

import java.io.IOException


/**
 * This class represents the possible API calls states
 */
sealed class NetworkResponse<out T, out U> {

    /**
     * Success response with body
     */
    data class Success<T>(val body: T) : NetworkResponse<T, Nothing>()

    /**
     * Failure response with body
     */
    data class ApiError<U>(val body: U, val code: Int) : NetworkResponse<Nothing, U>()

    /**
     * Failure response with code 401 or 403
     */
    data class AccessForbiddenError<U>(val body: U, val code: Int) : NetworkResponse<Nothing, U>()

    /**
     * Network error
     */
    data class NetworkError(val error: IOException) : NetworkResponse<Nothing, Nothing>()

    /**
     * For example, json parsing error
     */
    data class UnknownError(val error: Throwable?) : NetworkResponse<Nothing, Nothing>()

}