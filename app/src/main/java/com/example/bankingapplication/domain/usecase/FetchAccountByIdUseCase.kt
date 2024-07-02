package com.example.bankingapplication.domain.usecase

import com.example.bankingapplication.domain.repository.AccountRepository
import javax.inject.Inject

class FetchAccountByIdUseCase @Inject constructor(
    private val accountRepository: AccountRepository
) {
    suspend operator fun invoke(id: Int) = accountRepository.fetchAccountById(id)
}