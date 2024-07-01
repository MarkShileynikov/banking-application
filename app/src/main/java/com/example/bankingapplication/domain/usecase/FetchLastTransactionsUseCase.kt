package com.example.bankingapplication.domain.usecase

import com.example.bankingapplication.domain.entity.Transaction
import com.example.bankingapplication.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchLastTransactionsUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {
    suspend operator fun invoke(): Flow<List<Transaction>> =
        transactionRepository.fetchLastTransactions()
}