package com.example.bankingapplication.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapplication.R
import com.example.bankingapplication.domain.entity.Transaction
import com.example.bankingapplication.presentation.components.BlueButton
import com.example.bankingapplication.presentation.components.InputField

@Composable
fun EditTransactionScreen(
    transaction: Transaction
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(id = R.string.transaction),
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        InputField(header = stringResource(id = R.string.transaction_was_applied_in), inputText = transaction.company)
        InputField(header = stringResource(id = R.string.transaction_number), inputText = transaction.transactionNumber)
        InputField(header = stringResource(id = R.string.date), inputText =  transaction.date)
        InputField(header = stringResource(id = R.string.transaction_status), inputText = transaction.status)
        InputField(header = stringResource(id = R.string.amount), inputText = transaction.amount)
        BlueButton(
            text = stringResource(id = R.string.okay),
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()) {}
    }
}