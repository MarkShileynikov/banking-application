package com.example.bankingapplication.data.repository

import com.example.bankingapplication.domain.entity.Transaction

fun getTransactionsList(): List<Transaction> {
    return listOf(
        Transaction(
            id = 0,
            company = "OOO Company",
            transactionNumber = "51213578",
            date = "01.06.2024",
            transactionStatus = "Executed",
            amount = 10.90
        ),
        Transaction(
            id = 0,
            company = "OOO Company2",
            transactionNumber = "51213578",
            date = "05.06.2024",
            transactionStatus = "Declined",
            amount = 11.09
        ),
        Transaction(
            id = 0,
            company = "OOO Company3",
            transactionNumber = "51213578",
            date = "09.06.2024",
            transactionStatus = "In progress",
            amount = 13.0
        ),
        Transaction(
            id = 0,
            company = "OOO Company4",
            transactionNumber = "51213578",
            date = "01.07.2024",
            transactionStatus = "Executed",
            amount = 15.0
        ),
        Transaction(
            id = 0,
            company = "OOO Company5",
            transactionNumber = "512132578",
            date = "09.06.2023",
            transactionStatus = "Declined",
            amount = 18.09
        ),
        Transaction(
            id = 0,
            company = "OOO Company6",
            transactionNumber = "51213578",
            date = "09.01.2024",
            transactionStatus = "In progress",
            amount = 9.0
        ),
        Transaction(
            id = 0,
            company = "OOO Company",
            transactionNumber = "51213578",
            date = "01.06.2024",
            transactionStatus = "Executed",
            amount = 10.90
        ),
        Transaction(
            id = 0,
            company = "OOO Company2",
            transactionNumber = "51213578",
            date = "05.06.2024",
            transactionStatus = "Declined",
            amount = 11.09
        ),
        Transaction(
            id = 0,
            company = "OOO Company3",
            transactionNumber = "51213578",
            date = "09.06.2024",
            transactionStatus = "In progress",
            amount = 13.09
        ),
        Transaction(
            id = 0,
            company = "OOO Company4",
            transactionNumber = "51213578",
            date = "01.07.2024",
            transactionStatus = "Executed",
            amount = 15.09
        ),
        Transaction(
            id = 0,
            company = "OOO Company5",
            transactionNumber = "512132578",
            date = "09.06.2023",
            transactionStatus = "Declined",
            amount = 18.09
        ),
        Transaction(
            id = 0,
            company = "OOO Company6",
            transactionNumber = "51213578",
            date = "09.01.2024",
            transactionStatus = "In progress",
            amount = 9.09
        )
    )
}

fun getRecentTransactions(): List<Transaction> {
    return listOf(
        Transaction(
            id = 0,
            company = "OOO Company",
            transactionNumber = "51213578",
            date = "01.06.2024",
            transactionStatus = "Executed",
            amount = 10.90
        ),
        Transaction(
            id = 0,
            company = "OOO Company2",
            transactionNumber = "51213578",
            date = "05.06.2024",
            transactionStatus = "Declined",
            amount = 11.09
        ),
        Transaction(
            id = 0,
            company = "OOO Company3",
            transactionNumber = "51213578",
            date = "09.06.2024",
            transactionStatus = "In progress",
            amount = 13.0
        ),
        Transaction(
            id = 0,
            company = "OOO Company4",
            transactionNumber = "51213578",
            date = "01.07.2024",
            transactionStatus = "Executed",
            amount = 5.09
        )
    )
}