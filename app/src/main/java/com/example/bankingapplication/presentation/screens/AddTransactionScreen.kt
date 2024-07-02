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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bankingapplication.R
import com.example.bankingapplication.presentation.components.BlueButton
import com.example.bankingapplication.presentation.components.InputField
import com.example.bankingapplication.presentation.vm.AddTransactionViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun AddTransactionScreen(
    navController: NavController,
) {
    val viewModel: AddTransactionViewModel = hiltViewModel()

    var company by remember { mutableStateOf("") }
    var transactionNumber by remember { mutableStateOf("") }
    var transactionStatus by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }

    val currentDate = remember {
        SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Date())
    }

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
            fontSize = 24.sp
        )
        InputField(
            header = stringResource(id = R.string.transaction_was_applied_in),
            inputText = company,
            isClickable = true,
            onValueChange = { company = it }
        )
        InputField(
            header = stringResource(id = R.string.transaction_number),
            inputText = transactionNumber,
            isClickable = true,
            onValueChange = { transactionNumber = it }
        )
        InputField(
            header = stringResource(id = R.string.date),
            inputText = currentDate,
            isClickable = false,
            onValueChange = {}
        )
        InputField(
            header = stringResource(id = R.string.transaction_status),
            inputText = transactionStatus,
            isClickable = true,
            onValueChange = { transactionStatus = it }
        )
        InputField(
            header = stringResource(id = R.string.amount),
            inputText = amount,
            isClickable = true,
            onValueChange = { amount = it }
        )
        BlueButton(
            text = stringResource(id = R.string.okay),
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth(),
            enabled = company.isNotEmpty() &&
                    transactionNumber.isNotEmpty() &&
                    transactionStatus.isNotEmpty() &&
                    amount.isNotEmpty(),
            onClick = {
                viewModel.setTransactionCompany(company)
                viewModel.setTransactionNumber(transactionNumber)
                viewModel.setTransactionDate(currentDate)
                viewModel.setTransactionStatus(transactionStatus)
                viewModel.setTransactionAmount(amount.toDoubleOrNull() ?: 0.0)
                viewModel.insertTransaction()
                navController.popBackStack()
            }
        )
    }
}
