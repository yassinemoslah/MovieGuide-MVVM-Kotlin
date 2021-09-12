package com.yassinemoslah.movieguide.network.retrofit

import com.yassinemoslah.movieguide.network.adapter.NetworkResponse
import com.yassinemoslah.movieguide.network.model.Category
import com.yassinemoslah.movieguide.network.model.Movie
import retrofit2.http.*

/**
 * This interface is used by retrofit to generate all possible
 * network calls to the backend.
 */
internal interface MovieGuideApi {

    @GET("getCategories.php")
    suspend fun getAllCategories(): NetworkResponse<ArrayList<Category>, Error>

    @GET("get{categoryName}Films.php")
    suspend fun getMoviesByCategory(@Path("categoryName") categoryName: String): NetworkResponse<ArrayList<Movie>, Error>

}