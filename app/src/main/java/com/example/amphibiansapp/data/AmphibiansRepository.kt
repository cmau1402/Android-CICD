package com.example.amphibiansapp.data

class AmphibiansRepository {

    suspend fun getAmphibians(): List<Amphibian> {
        return RetrofitInstance.api.getAmphibians()
    }
}