package com.example.bankingapplication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bankingapplication.presentation.screens.AllTransactionsScreen
import com.example.bankingapplication.presentation.screens.RecentTransactionsScreen

@Composable
fun SetNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        route = "root",
        startDestination = "recent_transactions_screen"
    ) {
        composable("recent_transactions_screen") {
            RecentTransactionsScreen(navController)
        }
        composable("all_transactions_screen") {
            AllTransactionsScreen(navController)
        }
    }
}