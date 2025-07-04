package com.example.testtaskcard.ui.theme.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.testtaskcard.ui.theme.screen.cardInfo.CardInfoScreen
import com.example.testtaskcard.ui.theme.screen.history.HistoryScreen

@Composable
fun AppScreen(
    viewModel: AppViewModel = hiltViewModel()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        AnimatedContent(
            modifier = Modifier,
            targetState = viewModel.appState,
        ) { state ->
            when(state) {
                is AppState.CardInfo -> {
                    CardInfoScreen(paddingValues = paddingValues)
                }
                is AppState.History -> {
                    HistoryScreen(paddingValues = paddingValues)
                }
            }
        }
    }
}