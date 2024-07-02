package com.example.bankingapplication.domain.usecase

import com.example.bankingapplication.domain.repository.AccountRepository
import javax.inject.Inject

class FetchAllAccountsUseCase @Inject constructor(
    private val accountRepository: AccountRepository
) {
    suspend operator fun invoke() = accountRepository.fetchAllAccounts()
}