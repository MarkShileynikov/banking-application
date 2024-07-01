    package com.example.bankingapplication.di

    import com.example.bankingapplication.domain.repository.AccountRepository
    import com.example.bankingapplication.domain.repository.TransactionRepository
    import com.example.bankingapplication.domain.usecase.FetchLastTransactionsUseCase
    import com.example.bankingapplication.domain.usecase.FillOutAccountsUseCase
    import com.example.bankingapplication.prefs.PrefsDataSource
    import dagger.Module
    import dagger.Provides
    import dagger.hilt.InstallIn
    import dagger.hilt.components.SingletonComponent

    @Module
    @InstallIn(SingletonComponent::class)
    object UseCaseModule {

        @Provides
        fun provideFillOutAccountsUseCase(repository: AccountRepository, prefsDataSource: PrefsDataSource): FillOutAccountsUseCase {
            return FillOutAccountsUseCase(repository, prefsDataSource)
        }

        @Provides
        fun provideFetchLastTransactionsUseCase(repository: TransactionRepository): FetchLastTransactionsUseCase {
            return FetchLastTransactionsUseCase(repository)
        }
    }