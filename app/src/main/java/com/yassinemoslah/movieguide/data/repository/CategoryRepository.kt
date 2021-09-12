package com.yassinemoslah.movieguide.data.repository

import com.yassinemoslah.movieguide.data.common.ApiErrorPayload
import com.yassinemoslah.movieguide.data.common.NetworkBoundResource
import com.yassinemoslah.movieguide.data.common.Resource
import com.yassinemoslah.movieguide.data.repository.converter.CategoryConverter
import com.yassinemoslah.movieguide.network.MovieGuideService
import com.yassinemoslah.movieguide.network.model.Category as NetworkCategory
import com.yassinemoslah.movieguide.data.model.Category as AppCategory

/**
 * This repository is used to get the categories data
 */
class CategoryRepository {
    suspend fun getCategories() : Resource<List<AppCategory>, ApiErrorPayload> {
        val response = MovieGuideService.getAllCategories()

        val networkBoundResource = object : NetworkBoundResource<List<AppCategory>, List<NetworkCategory>>() {
            override fun convertNetworkResponse(item: List<NetworkCategory>): List<AppCategory> {
                return item.map { CategoryConverter.convert(it) }
            }
        }

        return networkBoundResource.boundNetworkResponse(response)
    }
}