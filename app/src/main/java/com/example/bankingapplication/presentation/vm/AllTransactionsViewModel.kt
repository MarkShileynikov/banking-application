package com.example.bankingapplication.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankingapplication.domain.entity.Transaction
import com.example.bankingapplication.domain.usecase.FetchAllTransactionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class AllTransactionsViewModel @Inject constructor(
    private val fetchAllTransactionsUseCase: FetchAllTransactionsUseCase
) : ViewModel() {

    private val originalTransactionsList = mutableListOf<Transaction>()

    val filteredTransactionsList = MutableStateFlow<List<Transaction>>(emptyList())

    init {
        fetchAllTransactions()
    }

    private fun fetchAllTransactions() {
        viewModelScope.launch {
            fetchAllTransactionsUseCase()
                .collect { transactions ->
                    originalTransactionsList.clear()
                    originalTransactionsList.addAll(transactions)
                    filteredTransactionsList.value = transactions
                }
        }
    }

    fun isDateRangeValid(startDate: String, endDate: String): Boolean {
        return if (startDate.isNotEmpty() && endDate.isNotEmpty()) {
            val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
            val startDateObj = LocalDate.parse(startDate, dateFormatter)
            val endDateObj = LocalDate.parse(endDate, dateFormatter)
            !startDateObj.isAfter(endDateObj)
        } else {
            false
        }
    }

    fun filterTransactions(startDate: String, endDate: String) {
        val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        val startDateObj = LocalDate.parse(startDate, dateFormatter)
        val endDateObj = LocalDate.parse(endDate, dateFormatter)

        filteredTransactionsList.value = originalTransactionsList.filter { transaction ->
            val transactionDate = LocalDate.parse(transaction.date, dateFormatter)
            !transactionDate.isBefore(startDateObj) && !transactionDate.isAfter(endDateObj)
        }
    }
}
