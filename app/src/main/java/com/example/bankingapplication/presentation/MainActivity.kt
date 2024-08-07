package com.example.bankingapplication.presentation

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.bankingapplication.presentation.navigation.SetNavigation
import com.example.bankingapplication.ui.theme.BankingApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fillOutAccounts()
        window.statusBarColor = Color.BLACK
        setContent {
            BankingApplicationTheme {
                SetNavigation()
            }
        }
    }
}
