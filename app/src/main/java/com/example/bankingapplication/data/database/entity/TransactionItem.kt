package com.example.bankingapplication.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class TransactionItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "account_id")
    val accountId: Int,
    val company: String,
    @ColumnInfo(name = "transaction_number")
    val transactionNumber: String,
    val date: String,
    @ColumnInfo(name = "transaction_status")
    val transactionStatus: String,
    val amount: Double
)
