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
import com.example.bankingapplication.presentation.vm.AddTransactionViewModel
import com.example.bankingapplication.presentation.vm.AllTransactionsViewModel
import com.example.bankingapplication.presentation.vm.RecentTransactionsViewModel

@Composable
fun SetNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        route = "root",
        startDestination = "recent_transactions_screen"
    ) {
        composable("recent_transactions_screen") {
            RecentTransactionsScreen(
                navController = navController,
            )
        }
        composable("all_transactions_screen") {
            AllTransactionScreen(
                navController = navController,
            )
        }
        composable("add_transactions_screen") {
            AddTransactionScreen(
                navController = navController,
            )
        }
        composable(
            route = "edit_transaction_screen/{company}/{number}/{date}/{status}/{amount}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                    defaultValue = 0
                },
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
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            val company = backStackEntry.arguments?.getString("company") ?: ""
            val number = backStackEntry.arguments?.getString("number") ?: ""
            val date = backStackEntry.arguments?.getString("date") ?: ""
            val status = backStackEntry.arguments?.getString("status") ?: ""
            EditTransactionScreen(
                transaction = Transaction(
                    id = id,
                    company = company,
                    transactionNumber = number,
                    date = date,
                    transactionStatus = status,
                    amount = 10.99
                ),
                navController = navController
            )
        }
    }
}