package com.example.bankingapplication.di

import com.example.bankingapplication.data.repository.AccountRepositoryImpl
import com.example.bankingapplication.data.repository.TransactionRepositoryImpl
import com.example.bankingapplication.domain.repository.AccountRepository
import com.example.bankingapplication.domain.repository.TransactionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideAccountRepository(accountRepositoryImpl: AccountRepositoryImpl): AccountRepository = accountRepositoryImpl

    @Provides
    fun provideTransactionRepository(transactionRepositoryImpl: TransactionRepositoryImpl): TransactionRepository = transactionRepositoryImpl

}