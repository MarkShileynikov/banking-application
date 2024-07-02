package com.example.bankingapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bankingapplication.data.database.dao.AccountDao
import com.example.bankingapplication.data.database.dao.TransactionDao
import com.example.bankingapplication.data.database.entity.AccountItem
import com.example.bankingapplication.data.database.entity.TransactionItem

@Database(entities = [AccountItem::class, TransactionItem::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract val accountDao: AccountDao

    abstract val transactionDao: TransactionDao
}