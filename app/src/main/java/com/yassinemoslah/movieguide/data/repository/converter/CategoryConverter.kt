package com.yassinemoslah.movieguide.data.repository.converter

import com.yassinemoslah.movieguide.data.model.Category as AppCategory
import com.yassinemoslah.movieguide.network.model.Category as NetworkCategory

/**
 * Converts a Category object from the backend
 * to an app domain Category object
 *
 * PS: In this example there is no difference but in big projects
 * they might be a difference between the network and the app domain objects, for example
 * we want to merge two fields from the network object into one field in the app domain object
 */
object CategoryConverter {
    fun convert(networkCategory: NetworkCategory): AppCategory {
        return AppCategory(networkCategory.name)
    }
}