package com.example.bankingapplication.domain.repository

interface AccountRepository {
    suspend fun fillOutAccounts()
}