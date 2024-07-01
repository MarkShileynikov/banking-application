package com.example.bankingapplication.domain.usecase

import com.example.bankingapplication.domain.repository.TransactionRepository
import javax.inject.Inject

class FetchLastTransacionsUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {
}