package com.arc.basicandroid.network

import com.arc.basicandroid.model.NewData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val BASE_URL ="https://newsapi.org/v2/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface NewsApiService {
    @GET("top-headlines?country=us&apiKey=8545a8cb50b4454c8dd2c195e892e94a")
    suspend fun getTopHeadlines():NewData

    @GET("everything?q=bitcoin&apiKey=8545a8cb50b4454c8dd2c195e892e94a")
    suspend fun getTopEverything():NewData
}

object Api{
    val newsApiService: NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }
}