package com.example.bankingapplication.presentation.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankingapplication.domain.entity.Account
import com.example.bankingapplication.domain.entity.Transaction
import com.example.bankingapplication.domain.usecase.FetchAccountByIdUseCase
import com.example.bankingapplication.domain.usecase.FetchAllAccountsUseCase
import com.example.bankingapplication.domain.usecase.FetchLastTransactionsUseCase
import com.example.bankingapplication.prefs.PrefsDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecentTransactionsViewModel @Inject constructor(
    private val fetchLastTransactionsUseCase: FetchLastTransactionsUseCase,
    private val fetchAllAccountsUseCase: FetchAllAccountsUseCase,
    private val fetchAccountByIdUseCase: FetchAccountByIdUseCase,
    private val prefsDataSource: PrefsDataSource
) : ViewModel() {

    val transactionList = MutableStateFlow<List<Transaction>>(emptyList())
    val accountList = MutableStateFlow<List<Account>>(emptyList())
    val selectedAccount = MutableStateFlow(
        Account(
            id = 0,
            name = "",
            number = 0,
            cardNumber = ""
        )
    )

    fun fetchLastTransactions() {
        viewModelScope.launch {
            fetchLastTransactionsUseCase()
                .onStart {
                    transactionList.value = emptyList()
                }
                .catch {}
                .collect { transactions ->
                    transactionList.value = transactions
                }
        }
    }

    fun fetchAllAccounts() {
        viewModelScope.launch {
            fetchAllAccountsUseCase()
                .onStart {
                    accountList.value = emptyList()
                }
                .catch { }
                .collect { accounts ->
                    accountList.value = accounts
                }
        }
    }

    fun fetchCurrentAccount() {
        viewModelScope.launch {
            val accountId = prefsDataSource.fetchCurrentUser()
            fetchAccountByIdUseCase(accountId)
                .onStart {
                    selectedAccount.value = Account(
                        id = 0,
                        name = "",
                        number = 0,
                        cardNumber = ""
                    )
                }
                .catch { e ->
                    Log.e("RecentTransactionsViewModel", "Error fetching account", e)
                }
                .collect { account ->
                    selectedAccount.value = account
                }
        }
    }

    fun changeCurrentAccount(id: Int) {
        viewModelScope.launch {
            prefsDataSource.setCurrentUser(id)
        }
    }
}