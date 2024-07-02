package com.example.bankingapplication.domain.repository

import com.example.bankingapplication.domain.entity.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {

    suspend fun fetchLastTransactions(): Flow<List<Transaction>>

    suspend fun insertTransaction(
        company: String,
        transactionNumber: String,
        date: String,
        transactionStatus: String,
        amount: Double
    )

    suspend fun fetchAllTransactions(): Flow<List<Transaction>>
}