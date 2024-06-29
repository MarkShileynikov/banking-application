package com.example.bankingapplication.di

import android.content.Context
import androidx.room.Room
import com.example.bankingapplication.data.database.Database
import com.example.bankingapplication.data.database.dao.AccountDao
import com.example.bankingapplication.data.database.dao.TransactionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(
            context.applicationContext,
            Database::class.java,
            "database"
        ).build()
    }

    @Provides
    fun provideAccountDao(database: Database): AccountDao = database.accountDao

    @Provides
    fun provideTransactionDao(database: Database): TransactionDao = database.transactionDao
}
