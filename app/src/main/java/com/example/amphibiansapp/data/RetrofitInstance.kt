package com.example.amphibiansapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL =
        "https://android-kotlin-fun-mars-server.appspot.com/"

    val api: AmphibiansApiService by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(AmphibiansApiService::class.java)
    }
}