package com.example.myapplication.network

import com.example.myapplication.model.Pokemon
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL = "https://tyradex.tech/api/v1"

interface ApiService {
    @GET("pokemon")
    suspend fun  getAllPokemon():List<Pokemon>



}

private val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create()) // For JSON parsing
    .baseUrl(BASE_URL)
    .build()

object PockApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}