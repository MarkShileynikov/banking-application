package com.example.bankingapplication.domain.repository

import com.example.bankingapplication.domain.entity.Account
import kotlinx.coroutines.flow.Flow

interface AccountRepository {

    suspend fun fillOutAccounts()

    suspend fun fetchAllAccounts(): Flow<List<Account>>

    suspend fun fetchAccountById(id: Int): Flow<Account>
}