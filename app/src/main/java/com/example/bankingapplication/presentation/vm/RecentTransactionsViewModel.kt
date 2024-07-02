package com.example.bankingapplication.presentation.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankingapplication.domain.entity.Transaction
import com.example.bankingapplication.domain.usecase.FetchLastTransactionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecentTransactionsViewModel @Inject constructor(
    private val fetchLastTransactionsUseCase: FetchLastTransactionsUseCase
) : ViewModel() {
    val transactionList = MutableStateFlow<List<Transaction>>(emptyList())

    fun fetchLastTransactions() {
        viewModelScope.launch {
            fetchLastTransactionsUseCase()
                .onStart {
                    transactionList.value = emptyList()
                }
                .catch {}
                .collect { transactions ->
                    transactionList.value = transactions
                }
        }
    }
}