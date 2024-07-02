package com.example.bankingapplication.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankingapplication.domain.entity.Transaction
import com.example.bankingapplication.domain.usecase.FetchAllTransactionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllTransactionsViewModel @Inject constructor(
    private val fetchAllTransactionsUseCase: FetchAllTransactionsUseCase
) : ViewModel() {

    val transactionsList = MutableStateFlow<List<Transaction>>(emptyList())

    fun fetchAllTransactions() {
        viewModelScope.launch {
            fetchAllTransactionsUseCase()
                .collect {transactions ->
                    transactionsList.value = transactions
                }
        }
    }
}