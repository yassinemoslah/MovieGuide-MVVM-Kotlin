package com.yassinemoslah.movieguide.data.common

import com.yassinemoslah.movieguide.data.repository.converter.ApiErrorConverter
import com.yassinemoslah.movieguide.network.adapter.NetworkResponse
import com.yassinemoslah.movieguide.network.common.ApiErrorPayload as NetworkApiError
import com.yassinemoslah.movieguide.data.common.ApiErrorPayload as AppApiError

/**
 * A generic class that allows easy conversion of the payloads we got from the network module.
 * These converted Payloads are then wrapped in a [Resource] object to allow easy error handling.
 *
 * @param ResultType The data class of the app domain
 * @param RequestType The data class of the network domain
 *
 */
abstract class NetworkBoundResource<ResultType, RequestType> {

    fun boundNetworkResponse(networkResponse: NetworkResponse<RequestType, NetworkApiError>): Resource<ResultType, AppApiError> {
        return when (networkResponse) {
            is NetworkResponse.Success -> Resource.Success(convertNetworkResponse(networkResponse.body))
            is NetworkResponse.AccessForbiddenError -> Resource.AccessForbiddenError(ApiErrorConverter.convert(networkResponse.body), networkResponse.code)
            is NetworkResponse.ApiError -> Resource.ApiError(ApiErrorConverter.convert(networkResponse.body), networkResponse.code)
            is NetworkResponse.NetworkError -> Resource.IOError(networkResponse.error)
            is NetworkResponse.UnknownError -> Resource.UnknownError(networkResponse.error)
        }
    }

    protected abstract fun convertNetworkResponse(item: RequestType) : ResultType
}