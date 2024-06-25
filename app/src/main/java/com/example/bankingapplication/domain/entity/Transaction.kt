package com.example.bankingapplication.domain.entity

data class Transaction(
    val company: String,
    val transactionNumber: String,
    val date: String,
    val status: String,
    val amount: String
)
