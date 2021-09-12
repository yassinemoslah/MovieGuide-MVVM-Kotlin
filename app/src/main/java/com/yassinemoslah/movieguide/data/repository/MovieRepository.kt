package com.yassinemoslah.movieguide.data.repository

import com.yassinemoslah.movieguide.data.common.ApiErrorPayload
import com.yassinemoslah.movieguide.data.common.NetworkBoundResource
import com.yassinemoslah.movieguide.data.common.Resource
import com.yassinemoslah.movieguide.data.repository.converter.MovieConverter
import com.yassinemoslah.movieguide.data.model.Movie as AppMovie
import com.yassinemoslah.movieguide.network.model.Movie as NetworkMovie
import com.yassinemoslah.movieguide.network.MovieGuideService

/**
 * This repository is used to get the movies data
 */
class MovieRepository {
    suspend fun getMoviesByCategory(categoryName: String) : Resource<List<AppMovie>, ApiErrorPayload> {
        val response = MovieGuideService.getMoviesByCategory(categoryName)

        val networkBoundResource = object : NetworkBoundResource<List<AppMovie>, List<NetworkMovie>>() {
            override fun convertNetworkResponse(item: List<NetworkMovie>): List<AppMovie> {
                return item.map { MovieConverter.convert(it) }
            }
        }

        return networkBoundResource.boundNetworkResponse(response)
    }
}