package com.example.bankingapplication.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bankingapplication.R
import com.example.bankingapplication.domain.entity.Transaction
import com.example.bankingapplication.presentation.components.AccountCard
import com.example.bankingapplication.presentation.components.TransactionCard
import com.example.bankingapplication.ui.theme.Blue
import com.example.bankingapplication.ui.theme.Grey
import com.example.bankingapplication.ui.theme.LightGrey

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RecentTransactionsScreen(
    navController: NavHostController
) {
    var isSheetOpened by rememberSaveable {
        mutableStateOf(false)
    }
    val transactionList = listOf(
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
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("add_transactions_screen") },
                containerColor = Blue,
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add",
                    tint = Color.White
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Text(
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.account)
            )
            AccountCard {
                isSheetOpened = true
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.recent_transactions),
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 16.dp)
                )
                Text(
                    text = stringResource(id = R.string.view_all),
                    color = Blue,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .clickable {
                            navController.navigate("all_transactions_screen")
                        }
                )
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Grey
                ),
                shape = RoundedCornerShape(16.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    val lastFourTransactions = transactionList.takeLast(4)
                    lastFourTransactions.forEach { transaction ->
                        TransactionCard(transaction = transaction, navController = navController)
                        HorizontalDivider(
                            color = LightGrey,
                            thickness = 1.dp,
                            modifier = Modifier
                                .padding(start = 16.dp, end = 16.dp)
                        )
                    }
                }
            }
        }
    }
    if (isSheetOpened) {
        ModalBottomSheet(
            onDismissRequest = { isSheetOpened = false },
            containerColor = Color.Black
        ) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.select_the_account),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
                AccountCard{}
                AccountCard{}
                AccountCard{}
            }
        }
    }
}



