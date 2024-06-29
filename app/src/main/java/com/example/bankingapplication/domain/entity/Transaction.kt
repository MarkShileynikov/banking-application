package com.example.bankingapplication.domain.entity

data class Transaction(
    val id: Int,
    val company: String,
    val transactionNumber: String,
    val date: String,
    val transactionStatus: String,
    val amount: Double
)
