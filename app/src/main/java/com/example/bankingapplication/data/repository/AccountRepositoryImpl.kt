package com.example.bankingapplication.data.repository

import com.example.bankingapplication.data.database.dao.AccountDao
import com.example.bankingapplication.data.database.entity.AccountItem
import com.example.bankingapplication.domain.repository.AccountRepository
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val accountDao: AccountDao,
) : AccountRepository {
    private val accountList = listOf(
        AccountItem(id = 0, name = "Mark", number = 885158542, cardNumber = "•••• 1234"),
        AccountItem(id = 1, name = "Olga", number = 985178284, cardNumber = "•••• 5660"),
        AccountItem(id = 2, name = "Valeriya", number = 457857489, cardNumber = "•••• 4880"),
        AccountItem(id = 3, name = "Gleb", number = 578541852, cardNumber = "•••• 1488")
    )

    override suspend fun fillOutAccounts() {
        accountList.forEach {
            accountDao.insert(it)
        }
    }
}