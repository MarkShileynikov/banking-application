package com.example.bankingapplication.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankingapplication.domain.usecase.InsertTransactionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTransactionViewModel @Inject constructor(
    private val insertTransactionUseCase: InsertTransactionUseCase
) : ViewModel() {

    private var transactionCompany: String? = null
    private var transactionNumber: String? = null
    private var transactionDate: String? = null
    private var transactionStatus: String? = null
    private var transactionAmount: Double? = null

    fun setTransactionCompany(company: String) {
        transactionCompany = company
    }

    fun setTransactionNumber(number: String) {
        transactionNumber = number
    }

    fun setTransactionDate(date: String) {
        transactionDate = date
    }

    fun setTransactionStatus(status: String) {
        transactionStatus = status
    }

    fun setTransactionAmount(amount: Double) {
        transactionAmount = amount
    }

    fun insertTransaction() {
        viewModelScope.launch {
            insertTransactionUseCase(
                company = transactionCompany ?: "",
                transactionNumber = transactionNumber ?: "",
                date = transactionDate ?: "",
                transactionStatus = transactionStatus ?: "",
                amount = transactionAmount ?: 0.0
            )
        }
    }
}
