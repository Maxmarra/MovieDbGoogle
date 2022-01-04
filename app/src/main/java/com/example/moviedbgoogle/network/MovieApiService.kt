package com.example.moviedbgoogle.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_URL = "https://api.themoviedb.org/3/"
private const val API_KEY="6f9ab437c43ec1fa9fb2dd9119d38c68"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MovieApiService {
    @GET("movie/popular?language=ru-RU")
    suspend fun getMovies(
        @Query("api_key") api_key: String = API_KEY
    ) : String
}

object MovieApi {
    val retrofitService : MovieApiService by lazy{
        retrofit.create(MovieApiService::class.java)
    }
}