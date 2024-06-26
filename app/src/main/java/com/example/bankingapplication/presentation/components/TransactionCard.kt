package com.example.bankingapplication.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapplication.R
import com.example.bankingapplication.domain.entity.Transaction
import com.example.bankingapplication.ui.theme.ArrowGrey
import com.example.bankingapplication.ui.theme.Grey
import com.example.bankingapplication.ui.theme.LightGrey

@Composable
fun TransactionCard(transaction: Transaction) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Grey),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
        ) {
            Text(
                text = transaction.company,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = transaction.date,
                color = LightGrey,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
            )
            val color = when (transaction.status) {
                "Executed" -> Color.Green
                "Declined" -> Color.Red
                "In progress" -> Color.Yellow
                else -> Color.White
            }
            Text(
                text = transaction.status,
                color = color,
                fontSize = 12.sp,
            )
        }
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = transaction.amount,
                color = Color.White,
                fontSize = 16.sp,
            )
            Image(
                painter = painterResource(id = R.drawable.arrow),
                contentDescription = "arrowButton",
                colorFilter = ColorFilter.tint(ArrowGrey),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .width(16.dp)
            )
        }
    }
}