package com.yassinemoslah.movieguide.network

import com.yassinemoslah.movieguide.network.retrofit.RetrofitInit

/**
 * Main entry point of the network layer.
 * Use this object to make any possible network call defined by [PublicApi]
 */
object MovieGuideService : PublicApi {

    private val api = RetrofitInit.getApi()

    override suspend fun getAllMoviesGroupedByCategory() = api.getAllMoviesGroupedByCategory()

}