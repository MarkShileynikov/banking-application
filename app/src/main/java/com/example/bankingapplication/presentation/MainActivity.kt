package com.example.bankingapplication.presentation

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.bankingapplication.data.database.Database
import com.example.bankingapplication.presentation.navigation.SetNavigation
import com.example.bankingapplication.ui.theme.BankingApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel : MainViewModel by viewModels()
    private lateinit var dataBase: Database
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.BLACK
        setContent {
            BankingApplicationTheme {
                SetNavigation()
            }
        }
    }
}
