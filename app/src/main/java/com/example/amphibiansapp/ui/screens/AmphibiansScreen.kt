package com.example.amphibiansapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibiansapp.ui.components.AmphibianCard
import com.example.amphibiansapp.viewmodel.AmphibianViewModel
import com.example.amphibiansapp.viewmodel.UiState

@Composable
fun AmphibiansScreen(
    viewModel: AmphibianViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    when (val currentState = uiState) {
        is UiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is UiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Failed to load amphibians.")
            }
        }
        is UiState.Success -> {
            LazyColumn {
                items(currentState.amphibians) { amphibian ->
                    AmphibianCard(
                        amphibian = amphibian
                    )
                }
            }
        }
    }
}