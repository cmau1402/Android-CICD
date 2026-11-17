package com.example.amphibiansapp.data

import retrofit2.http.GET

interface AmphibiansApiService {

    @GET("Amphibians")
    suspend fun getAmphibians(): List<Amphibian>
}