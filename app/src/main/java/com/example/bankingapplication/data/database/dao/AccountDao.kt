package com.example.bankingapplication.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.bankingapplication.data.database.entity.AccountItem
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDao {
    @Insert
    suspend fun insert(accountItem: AccountItem)

    @Query("SELECT * FROM accounts")
    fun fetchAllAccounts(): Flow<List<AccountItem>>
}