package com.example.bankingapplication.domain.usecase

import com.example.bankingapplication.domain.repository.AccountRepository
import com.example.bankingapplication.prefs.PrefsDataSource
import javax.inject.Inject

class FillOutAccountsUseCase @Inject constructor(
    private val accountRepository: AccountRepository,
    private val prefsDataSource: PrefsDataSource
) {
    suspend operator fun invoke() {
        if (prefsDataSource.isFirstLaunch()) {
            accountRepository.fillOutAccounts()
            prefsDataSource.setFirstLaunch(false)
        }
    }
}