package com.example.testtaskcard.ui.theme.screen

sealed class AppState {
    data object CardInfo : AppState()
    data object History : AppState()
}