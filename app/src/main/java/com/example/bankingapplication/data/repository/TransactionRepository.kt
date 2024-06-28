package com.example.bankingapplication.data.repository

import com.example.bankingapplication.domain.entity.Transaction

fun getTransactionsList(): List<Transaction> {
    return listOf(
        Transaction(
            company = "OOO Company",
            transactionNumber = "51213578",
            date = "01.06.2024",
            status = "Executed",
            amount = "$10.90"
        ),
        Transaction(
            company = "OOO Company2",
            transactionNumber = "51213578",
            date = "05.06.2024",
            status = "Declined",
            amount = "$11.09"
        ),
        Transaction(
            company = "OOO Company3",
            transactionNumber = "51213578",
            date = "09.06.2024",
            status = "In progress",
            amount = "$13.09"
        ),
        Transaction(
            company = "OOO Company4",
            transactionNumber = "51213578",
            date = "01.07.2024",
            status = "Executed",
            amount = "$15.09"
        ),
        Transaction(
            company = "OOO Company5",
            transactionNumber = "512132578",
            date = "09.06.2023",
            status = "Declined",
            amount = "$18.09"
        ),
        Transaction(
            company = "OOO Company6",
            transactionNumber = "51213578",
            date = "09.01.2024",
            status = "In progress",
            amount = "$9.09"
        ),
        Transaction(
            company = "OOO Company",
            transactionNumber = "51213578",
            date = "01.06.2024",
            status = "Executed",
            amount = "$10.90"
        ),
        Transaction(
            company = "OOO Company2",
            transactionNumber = "51213578",
            date = "05.06.2024",
            status = "Declined",
            amount = "$11.09"
        ),
        Transaction(
            company = "OOO Company3",
            transactionNumber = "51213578",
            date = "09.06.2024",
            status = "In progress",
            amount = "$13.09"
        ),
        Transaction(
            company = "OOO Company4",
            transactionNumber = "51213578",
            date = "01.07.2024",
            status = "Executed",
            amount = "$15.09"
        ),
        Transaction(
            company = "OOO Company5",
            transactionNumber = "512132578",
            date = "09.06.2023",
            status = "Declined",
            amount = "$18.09"
        ),
        Transaction(
            company = "OOO Company6",
            transactionNumber = "51213578",
            date = "09.01.2024",
            status = "In progress",
            amount = "$9.09"
        )
    )
}

fun getRecentTransactions(): List<Transaction> {
    return listOf(
        Transaction(
            company = "OOO Company",
            transactionNumber = "51213578",
            date = "01.06.2024",
            status = "Executed",
            amount = "$10.90"
        ),
        Transaction(
            company = "OOO Company2",
            transactionNumber = "51213578",
            date = "05.06.2024",
            status = "Declined",
            amount = "$11.09"
        ),
        Transaction(
            company = "OOO Company3",
            transactionNumber = "51213578",
            date = "09.06.2024",
            status = "In progress",
            amount = "$13.09"
        ),
        Transaction(
            company = "OOO Company4",
            transactionNumber = "51213578",
            date = "01.07.2024",
            status = "Executed",
            amount = "$15.09"
        )
    )
}