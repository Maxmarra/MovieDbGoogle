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

    private val _movies = MutableLiveData<List<MovieResponse.Movie>>()
    val movies: LiveData<List<MovieResponse.Movie>> = _movies

    init {
        getMoviePhotos()
    }
    private fun getMoviePhotos() {
        viewModelScope.launch {

            try{
                _movies.value = MovieApi.retrofitService.getMovies().body()?.results
                _status.value = " Success: Movies retrieved"


            }catch (e: Exception){
                _status.value = "Failure: ${e.message}"
            }

        }
    }
}