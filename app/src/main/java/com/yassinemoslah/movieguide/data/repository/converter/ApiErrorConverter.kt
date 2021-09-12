package com.yassinemoslah.movieguide.data.repository.converter

import com.yassinemoslah.movieguide.data.common.ApiErrorPayload as AppApiError
import com.yassinemoslah.movieguide.network.common.ApiErrorPayload as NetworkApiError

/**
 * Converts an ApiError object from the backend
 * to an app domain ApiError object
 */
object ApiErrorConverter {
    fun convert(networkApiError: NetworkApiError): AppApiError {
        return AppApiError(networkApiError.statusCode, networkApiError.errorMessage)
    }
}