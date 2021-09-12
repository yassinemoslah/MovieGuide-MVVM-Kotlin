package com.yassinemoslah.movieguide.data.common

import java.io.IOException

/**
 * A generic class that represents the possible resource invocation states.
 */
sealed class Resource<out T, out U> {
    /**
     * Success response with body
     */
    data class Success<T>(val body: T) : Resource<T, Nothing>()

    /**
     * Failure response with body
     */
    data class ApiError<U>(val body: U, val code: Int) : Resource<Nothing, U>()

    /**
     * Failure response with code 401 or 403
     */
    data class AccessForbiddenError<U>(val body: U, val code: Int) : Resource<Nothing, U>()

    /**
     * Network/Database read/write error
     */
    data class IOError(val error: IOException) : Resource<Nothing, Nothing>()

    /**
     * For example, json parsing error
     */
    data class UnknownError(val error: Throwable?) : Resource<Nothing, Nothing>()
}