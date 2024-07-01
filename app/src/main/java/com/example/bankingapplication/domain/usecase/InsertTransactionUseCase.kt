package com.example.bankingapplication.domain.usecase

import com.example.bankingapplication.domain.repository.TransactionRepository
import javax.inject.Inject

class InsertTransactionUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {
    suspend operator fun invoke(
        company: String,
        transactionNumber: String,
        date: String,
        transactionStatus: String,
        amount: Double
    ) {
        transactionRepository.insertTransaction(
            company = company,
            transactionNumber = transactionNumber,
            date = date,
            transactionStatus = transactionStatus,
            amount = amount
        )
    }
}