package com.yassinemoslah.movieguide.network

import com.yassinemoslah.movieguide.network.adapter.NetworkResponse
import com.yassinemoslah.movieguide.network.common.ApiErrorPayload
import com.yassinemoslah.movieguide.network.model.Category
import com.yassinemoslah.movieguide.network.model.Movie
/**
 * This interface defines all possible API calls provided
 * by the network layer to the outside world.
 */
internal interface PublicApi {

    /**
     * @return a List of [Category]s
     */
    suspend fun getAllMoviesGroupedByCategory(): NetworkResponse<List<Category>, ApiErrorPayload>

}