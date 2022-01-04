package com.example.moviedbgoogle.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedbgoogle.network.MovieApi
import com.example.moviedbgoogle.network.MovieResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    init {
        getMoviePhotos()
    }
    private fun getMoviePhotos() {
        viewModelScope.launch {

            try{
                val listResult = MovieApi.retrofitService.getMovies()
                _status.value = "Success: ${listResult.body()?.results?.size} Movies retrieved"

            }catch (e: Exception){
                _status.value = "Failure: ${e.message}"
            }

        }
    }
}