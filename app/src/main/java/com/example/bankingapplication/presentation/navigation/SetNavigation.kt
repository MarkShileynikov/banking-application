package com.example.bankingapplication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bankingapplication.domain.entity.Transaction
import com.example.bankingapplication.presentation.screens.AddTransactionScreen
import com.example.bankingapplication.presentation.screens.AllTransactionScreen
import com.example.bankingapplication.presentation.screens.EditTransactionScreen
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
            AllTransactionScreen(navController)
        }
        composable("add_transactions_screen") {
            AddTransactionScreen()
        }
        composable(
            route = "edit_transaction_screen/{company}/{number}/{date}/{status}/{amount}",
            arguments = listOf(
                navArgument("company") {
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument("number") {
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument("date") {
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument("status") {
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument("amount") {
                    type = NavType.StringType
                    defaultValue = ""
                },
            )
        ) { backStackEntry ->
            val company = backStackEntry.arguments?.getString("company") ?: ""
            val number = backStackEntry.arguments?.getString("number") ?: ""
            val date = backStackEntry.arguments?.getString("date") ?: ""
            val status = backStackEntry.arguments?.getString("status") ?: ""
            val amount = backStackEntry.arguments?.getString("amount") ?: ""
            EditTransactionScreen(
                transaction = Transaction(
                    company = company,
                    transactionNumber = number,
                    date = date,
                    status = status,
                    amount = amount
                )
            )
        }

    }
}