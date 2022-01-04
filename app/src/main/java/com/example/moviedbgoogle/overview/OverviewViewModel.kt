package com.example.moviedbgoogle.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedbgoogle.network.MovieApi
import com.example.moviedbgoogle.network.MovieResponse
import kotlinx.coroutines.launch
import java.lang.Exception

enum class MovieApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel : ViewModel() {



    private val _movies = MutableLiveData<List<MovieResponse.Movie>>()
    val movies: LiveData<List<MovieResponse.Movie>> = _movies

    private val _status = MutableLiveData<MovieApiStatus>()
    val status: LiveData<MovieApiStatus> = _status

    init {
        getMoviePhotos()
    }
    private fun getMoviePhotos() {
        viewModelScope.launch {
            _status.value = MovieApiStatus.LOADING

            try{
                _movies.value = MovieApi.retrofitService.getMovies().body()?.results
                _status.value = MovieApiStatus.DONE


            }catch (e: Exception){
                _status.value = MovieApiStatus.ERROR
                _movies.value = listOf()
            }

        }
    }
}