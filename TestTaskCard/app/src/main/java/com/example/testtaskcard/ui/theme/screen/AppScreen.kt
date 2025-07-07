package com.example.testtaskcard.ui.theme.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testtaskcard.ui.theme.screen.cardInfo.CardInfoScreen
import com.example.testtaskcard.ui.theme.screen.history.HistoryScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppScreen(
    viewModel: AppViewModel = hiltViewModel()
) {

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = "card_info_screen"
        ) {
            composable(
                route = "card_info_screen",
                enterTransition = {
                    slideInHorizontally(initialOffsetX = { 1000 })
                },
                exitTransition = {
                    slideOutHorizontally(targetOffsetX = { -1000 })
                },
                popEnterTransition = {
                    slideInHorizontally(initialOffsetX = { -1000 })
                },
                popExitTransition = {
                    slideOutHorizontally(targetOffsetX = { 1000 })
                }
            ) {
                CardInfoScreen(paddingValues = paddingValues) {
                    navController.navigate("history_screen")
                }
            }
            composable(
                route = "history_screen",
                enterTransition = {
                    slideInHorizontally(initialOffsetX = { 1000 })
                },
                exitTransition = {
                    slideOutHorizontally(targetOffsetX = { -1000 })
                },
                popEnterTransition = {
                    slideInHorizontally(initialOffsetX = { -1000 })
                },
                popExitTransition = {
                    slideOutHorizontally(targetOffsetX = { 1000 })
                }
            ) {
                HistoryScreen(
                    paddingValues = paddingValues,
                    onBackButtonClick = { navController.popBackStack() }
                )
            }
        }
    }
}