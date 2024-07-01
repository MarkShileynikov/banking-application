package com.example.bankingapplication.di

import com.example.bankingapplication.data.repository.AccountRepositoryImpl
import com.example.bankingapplication.domain.repository.AccountRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideAccountRepository(accountRepositoryImpl: AccountRepositoryImpl): AccountRepository = accountRepositoryImpl
}