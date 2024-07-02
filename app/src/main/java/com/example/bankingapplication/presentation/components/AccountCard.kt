package com.example.bankingapplication.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.bankingapplication.R
import com.example.bankingapplication.domain.entity.Account
import com.example.bankingapplication.ui.theme.DarkBlue
import com.example.bankingapplication.ui.theme.Grey
import com.example.bankingapplication.ui.theme.LightGrey

@Composable
fun AccountCard(
    account: Account,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) DarkBlue else Grey
        ),
        shape = RoundedCornerShape(16.dp),
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val (image, accountData, arrowButton) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.card),
                contentDescription = "cardImage",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .padding(16.dp)
                    .width(40.dp)
            )
            Column(
                modifier = Modifier
                    .constrainAs(accountData) {
                        top.linkTo(parent.top)
                        start.linkTo(image.end)
                        bottom.linkTo(parent.bottom)
                    }
                    .padding(top = 16.dp, bottom = 16.dp),
            ) {
                Text(
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    text = account.name
                )
                Text(
                    color = LightGrey,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    text = account.number.toString(),
                )
                Text(
                    color = LightGrey,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    text = account.cardNumber,
                )
            }
            Image(painter = painterResource(id = R.drawable.arrow),
                contentDescription = "arrowButton",
                colorFilter = ColorFilter.tint(LightGrey),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .constrainAs(arrowButton) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
                    .padding(end = 16.dp)
                    .width(16.dp)
            )
        }
    }
}