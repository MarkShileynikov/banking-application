package com.example.bankingapplication.data.repository

import com.example.bankingapplication.data.database.dao.AccountDao
import com.example.bankingapplication.data.database.entity.AccountItem
import com.example.bankingapplication.domain.entity.Account
import com.example.bankingapplication.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val accountDao: AccountDao,
) : AccountRepository {
    private val accountList = listOf(
        AccountItem(name = "Mark", number = 885158542, cardNumber = "•••• 1234"),
        AccountItem(name = "Olga", number = 985178284, cardNumber = "•••• 5660"),
        AccountItem(name = "Valeriya", number = 457857489, cardNumber = "•••• 4880"),
        AccountItem(name = "Gleb", number = 578541852, cardNumber = "•••• 1488")
    )

    override suspend fun fillOutAccounts() {
        accountList.forEach {
            accountDao.insert(it)
        }
    }

    override suspend fun fetchAllAccounts(): Flow<List<Account>> {
        return accountDao.fetchAllAccounts().map { accounts ->
            accounts.map { account ->
                transformToAccount(account)
            }
        }
    }

    override suspend fun fetchAccountById(id: Int): Flow<Account> {
        return accountDao.fetchAccountById(id).map { account ->
            transformToAccount(account)
        }
    }

    private fun transformToAccount(accountItem: AccountItem): Account {
        return Account(
            id = accountItem.id,
            name = accountItem.name,
            number = accountItem.number,
            cardNumber = accountItem.cardNumber
        )
    }
}