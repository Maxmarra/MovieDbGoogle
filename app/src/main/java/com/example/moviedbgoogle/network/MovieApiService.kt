package com.example.moviedbgoogle.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_URL = "https://api.themoviedb.org/3/"
private const val API_KEY="6f9ab437c43ec1fa9fb2dd9119d38c68"
const val IMAGE_URL = "https://image.tmdb.org/t/p/w500";

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MovieApiService {
    @GET("movie/popular?language=ru-RU")
    suspend fun getMovies(
        @Query("api_key") api_key: String = API_KEY
    ) : Response<MovieResponse>
}

object MovieApi {
    val retrofitService : MovieApiService by lazy{
        retrofit.create(MovieApiService::class.java)
    }
}