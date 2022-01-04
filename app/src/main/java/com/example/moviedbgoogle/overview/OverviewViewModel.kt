package com.example.moviedbgoogle.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OverviewViewModel : ViewModel() {
    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMoviePhotos()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MoviePhoto] [List] [LiveData].
     */
    private fun getMoviePhotos() {
        _status.value = "Set the Movie API status response here!"
    }
}