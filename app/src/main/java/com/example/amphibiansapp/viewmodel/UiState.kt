package com.example.amphibiansapp.viewmodel

import com.example.amphibiansapp.data.Amphibian

sealed interface UiState {
    object Loading : UiState
    data class Success(
        val amphibians: List<Amphibian>
    ) : UiState
    object Error : UiState
}