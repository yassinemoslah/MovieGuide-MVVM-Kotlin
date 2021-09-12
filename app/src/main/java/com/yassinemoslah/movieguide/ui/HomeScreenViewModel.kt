package com.yassinemoslah.movieguide.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yassinemoslah.movieguide.data.common.Resource
import com.yassinemoslah.movieguide.data.model.Category
import com.yassinemoslah.movieguide.data.repository.MovieRepository
import kotlinx.coroutines.launch

/**
 * This is the ViewModel for the home screen
 * It gets the list of all the movies
 */
class HomeScreenViewModel : BaseViewModel() {

    private val movieRepository = MovieRepository()

    override val _isLoading = MutableLiveData(true)

    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>>
        get() = _categories


    init {
        getMoviesGroupedByCategory()
    }

    fun getMoviesGroupedByCategory() {
        viewModelScope.launch {
            when (val response = movieRepository.getAllMoviesGroupedByCategory()) {
                is Resource.Success -> _categories.value = response.body
                is Resource.ApiError -> _isApiError.value = true
                is Resource.IOError -> _isNetworkError.value = true
                is Resource.UnknownError -> _isUnknownError.value = true
                is Resource.AccessForbiddenError -> _isApiError.value = true
            }
            _isLoading.value = false
        }
    }

}