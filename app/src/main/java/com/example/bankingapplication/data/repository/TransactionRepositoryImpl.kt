package com.example.bankingapplication.data.repository

import com.example.bankingapplication.data.database.dao.TransactionDao
import com.example.bankingapplication.data.database.entity.TransactionItem
import com.example.bankingapplication.domain.entity.Transaction
import com.example.bankingapplication.domain.repository.TransactionRepository
import com.example.bankingapplication.prefs.PrefsDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val transactionDao: TransactionDao,
    private val prefsDataSource: PrefsDataSource
) : TransactionRepository {

    override suspend fun fetchLastTransactions(): Flow<List<Transaction>> {
        val accountId = prefsDataSource.fetchCurrentUser()
        return transactionDao.fetchLastTransactions(accountId).map { transactions ->
            transactions.map { transaction ->
                transformToTransaction(transaction)
            }
        }
    }

    override suspend fun insertTransaction(
        company: String,
        transactionNumber: String,
        date: String,
        transactionStatus: String,
        amount: Double
    ) {
        val transactionItem = TransactionItem(
            accountId = prefsDataSource.fetchCurrentUser(),
            company = company.trim().replace("\\s+".toRegex(), " "),
            transactionNumber = transactionNumber.trim().replace("\\s+".toRegex(), ""),
            date = date,
            transactionStatus = transactionStatus.trim().replace("\\s+".toRegex(), " "),
            amount = amount
        )
        transactionDao.insert(transactionItem)
    }

    override suspend fun fetchAllTransactions(): Flow<List<Transaction>> {
        val accountId = prefsDataSource.fetchCurrentUser()
        return transactionDao.fetchAllTransactions(accountId).map {transactions ->
            transactions.map { transaction ->
                transformToTransaction(transaction)
            }
        }
    }

    private fun transformToTransaction(transactionItem: TransactionItem) : Transaction {
        return Transaction(
            id = transactionItem.id,
            company = transactionItem.company,
            transactionNumber = transactionItem.transactionNumber,
            date = transactionItem.date,
            transactionStatus = transactionItem.transactionStatus,
            amount = transactionItem.amount
        )
    }
}
