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

    private val _movies = MutableLiveData<MovieResponse.Movie>()
    val movies: LiveData<MovieResponse.Movie> = _movies

    init {
        getMoviePhotos()
    }
    private fun getMoviePhotos() {
        viewModelScope.launch {

            try{
                _movies.value = MovieApi.retrofitService.getMovies().body()?.results?.get(0)
                _status.value = "   First Movie image URL : ${_movies.value!!.imgSrcUrl}"


            }catch (e: Exception){
                _status.value = "Failure: ${e.message}"
            }

        }
    }
}