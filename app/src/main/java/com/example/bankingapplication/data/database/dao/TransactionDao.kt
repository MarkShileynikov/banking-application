package com.example.bankingapplication.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.bankingapplication.data.database.entity.TransactionItem
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Insert
    suspend fun insert(transactionItem: TransactionItem)

    @Query("SELECT * FROM transactions")
    fun fetchAllTransactions(): Flow<List<TransactionItem>>

    @Query("SELECT * FROM transactions WHERE id = :id")
    fun fetchTransactionById(id: Int): Flow<TransactionItem?>

    @Query("SELECT * FROM transactions WHERE account_id = :accountId ORDER BY id DESC LIMIT 5")
    fun fetchLastTransactions(accountId: Int): Flow<List<TransactionItem>>
}