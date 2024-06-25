package com.example.bankingapplication

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bankingapplication.presentation.screens.RecentTransactionsScreen
import com.example.bankingapplication.ui.theme.BankingApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.BLACK
        setContent {
            BankingApplicationTheme {
                RecentTransactionsScreen()
            }
        }
    }
}
