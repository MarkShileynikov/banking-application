package com.example.bankingapplication.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
data class AccountItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val number: Int,
    @ColumnInfo(name = "card_number")
    val cardNumber: String
)
