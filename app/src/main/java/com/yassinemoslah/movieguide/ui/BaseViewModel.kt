package com.yassinemoslah.movieguide.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * The BaseViewModel contains the basic variables and functions we need for handling network calls
 */
open class BaseViewModel : ViewModel() {

    open val _isNetworkError = MutableLiveData(false)
    open val isNetworkError: LiveData<Boolean>
        get() = _isNetworkError

    open val _isApiError = MutableLiveData(false)
    open val isApiError: LiveData<Boolean>
        get() = _isApiError

    open val _isUnknownError = MutableLiveData(false)
    open val isUnknownError: LiveData<Boolean>
        get() = _isUnknownError


    open val _isLoading = MutableLiveData(false)
    open val isLoading: LiveData<Boolean>
        get() = _isLoading

    open fun resetNetworkError() {
        _isNetworkError.value = false
    }

    open fun resetApiError() {
        _isApiError.value = false
    }

    open fun resetUnknownError() {
        _isUnknownError.value = false
    }

}