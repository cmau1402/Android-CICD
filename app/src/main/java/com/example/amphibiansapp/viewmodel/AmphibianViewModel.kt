package com.example.amphibiansapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibiansapp.data.AmphibiansRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AmphibianViewModel : ViewModel() {
    private val repository = AmphibiansRepository()
    private val _uiState =
        MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState>
        get() = _uiState
    init {
        fetchAmphibians()
    }
    private fun fetchAmphibians() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val amphibians =
                    repository.getAmphibians()
                _uiState.value =
                    UiState.Success(amphibians)
            } catch (e: Exception) {
                _uiState.value =
                    UiState.Error
            }
        }
    }
}