package com.example.bankingapplication.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bankingapplication.R
import com.example.bankingapplication.domain.entity.Transaction
import com.example.bankingapplication.presentation.components.TransactionCard
import com.example.bankingapplication.ui.theme.Grey
import com.example.bankingapplication.ui.theme.LightGrey

@Composable
fun AllTransactionsScreen(
    navController: NavHostController
) {
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Image(
                painter = painterResource(id = R.drawable.arrow),
                contentDescription = "arrowButton",
                colorFilter = ColorFilter.tint(Color.White),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .width(16.dp)
                    .scale(scaleX = -1f, scaleY = 1f)
                    .clickable {
                        navController.popBackStack()
                    }
            )
            Text(
                text = stringResource(id = R.string.all_transactions),
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(id = R.drawable.filter),
                contentDescription = "arrowButton",
                colorFilter = ColorFilter.tint(Color.White),
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(24.dp),
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                itemsIndexed(transactionList) { _, transaction ->
                    TransactionCard(transaction = transaction)
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