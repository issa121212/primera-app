package com.example.primeraapp.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.primeraapp.ui.screens.DisplayScreen
import com.example.primeraapp.ui.screens.InputScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val sharedViewModel: SharedFormViewModel = viewModel()

    NavHost(navController = navController, startDestination = "input") {
        composable("input") {
            InputScreen(
                viewModel = sharedViewModel,
                onNavigateToDisplay = { navController.navigate("display") }
            )
        }
        composable("display") {
            DisplayScreen(
                viewModel = sharedViewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}