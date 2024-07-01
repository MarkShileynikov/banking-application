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
    fun getAllTransactions(): Flow<List<TransactionItem>>

    @Query("SELECT * FROM transactions WHERE id = :id")
    fun getTransactionById(id: Int): Flow<TransactionItem?>
}