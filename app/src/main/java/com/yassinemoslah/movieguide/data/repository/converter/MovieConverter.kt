package com.yassinemoslah.movieguide.data.repository.converter

import com.yassinemoslah.movieguide.network.model.Movie as NetworkMovie
import com.yassinemoslah.movieguide.data.model.Movie as AppMovie


/**
 * Converts a Movie object from the backend
 * to an app domain Movie object
 */
object MovieConverter {

    fun convert(networkMovie: NetworkMovie): AppMovie {
        return AppMovie(
            networkMovie.id,
            networkMovie.title,
            networkMovie.year,
            networkMovie.image,
            networkMovie.description,
            networkMovie.trailerUrl
        )
    }

}