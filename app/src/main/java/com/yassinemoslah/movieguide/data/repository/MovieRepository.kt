package com.yassinemoslah.movieguide.data.repository

import com.yassinemoslah.movieguide.data.common.ApiErrorPayload
import com.yassinemoslah.movieguide.data.common.NetworkBoundResource
import com.yassinemoslah.movieguide.data.common.Resource
import com.yassinemoslah.movieguide.data.model.Category as AppCategory
import com.yassinemoslah.movieguide.network.model.Category as NetworkCategory
import com.yassinemoslah.movieguide.data.repository.converter.CategoryConverter
import com.yassinemoslah.movieguide.network.MovieGuideService

/**
 * This repository is used to get the movies data
 */
class MovieRepository {

    suspend fun getAllMoviesGroupedByCategory() : Resource<List<AppCategory>, ApiErrorPayload> {
        val response = MovieGuideService.getAllMoviesGroupedByCategory()

        val networkBoundResource = object : NetworkBoundResource<List<AppCategory>, List<NetworkCategory>>() {
            override fun convertNetworkResponse(item: List<com.yassinemoslah.movieguide.network.model.Category>): List<AppCategory> {
                return item.map { CategoryConverter.convert(it) }
            }
        }

        return networkBoundResource.boundNetworkResponse(response)
    }
}