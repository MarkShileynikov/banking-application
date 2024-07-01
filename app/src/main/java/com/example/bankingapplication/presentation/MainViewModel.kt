package com.example.bankingapplication.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankingapplication.domain.usecase.FillOutAccountsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    context: Application,
    private val fillOutAccountsUseCase: FillOutAccountsUseCase
) : AndroidViewModel(context) {
    init {
        viewModelScope.launch {
            fillOutAccountsUseCase()
        }
    }
}