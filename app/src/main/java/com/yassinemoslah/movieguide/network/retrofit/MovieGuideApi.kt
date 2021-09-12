package com.yassinemoslah.movieguide.network.retrofit

import com.yassinemoslah.movieguide.network.adapter.NetworkResponse
import com.yassinemoslah.movieguide.network.common.ApiErrorPayload
import com.yassinemoslah.movieguide.network.model.Category
import retrofit2.http.*

/**
 * This interface is used by retrofit to generate all possible
 * network calls to the backend.
 */
internal interface MovieGuideApi {

    @GET("getAllMoviesGroupedByCategory.php")
    suspend fun getAllMoviesGroupedByCategory(): NetworkResponse<List<Category>, ApiErrorPayload>
}