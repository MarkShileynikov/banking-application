package com.example.bankingapplication.presentation.screens

import android.widget.CalendarView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bankingapplication.R
import com.example.bankingapplication.presentation.components.BlueButton
import com.example.bankingapplication.presentation.components.TransactionCard
import com.example.bankingapplication.presentation.vm.AllTransactionsViewModel
import com.example.bankingapplication.ui.theme.Grey
import com.example.bankingapplication.ui.theme.LightGrey
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllTransactionScreen(
    navController: NavController,
) {
    val viewModel: AllTransactionsViewModel = hiltViewModel()

    var isSheetOpened by rememberSaveable {
        mutableStateOf(false)
    }
    val transactions = viewModel.transactionsList.collectAsState(initial = emptyList())
    viewModel.fetchAllTransactions()

    var showStartDatePicker by rememberSaveable {
        mutableStateOf(false)
    }
    var showEndDatePicker by rememberSaveable {
        mutableStateOf(false)
    }

    var startDate by remember {
        mutableStateOf("")
    }

    var endDate by remember {
        mutableStateOf("")
    }

    var borderColor by remember {
        mutableStateOf(LightGrey)
    }

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
                    .size(24.dp)
                    .clickable { isSheetOpened = true },
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
                itemsIndexed(transactions.value) { _, transaction ->
                    TransactionCard(
                        transaction = transaction,
                        navController = navController
                    )
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
    if (isSheetOpened) {
        ModalBottomSheet(
            onDismissRequest = { isSheetOpened = false },
            containerColor = Color.Black
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = stringResource(id = R.string.filter_by_date),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp
                )
                Text(
                    text = stringResource(id = R.string.start_date),
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Row(
                    modifier = Modifier
                        .border(
                            color = borderColor,
                            width = 1.dp,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            showStartDatePicker = true
                            showEndDatePicker = false
                        },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = startDate.ifEmpty { stringResource(id = R.string.select_start_date) },
                        color = LightGrey,
                        fontSize = 16.sp
                    )
                    Image(
                        painter = painterResource(id = R.drawable.calendar),
                        contentDescription = "calendarIcon",
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier.size(16.dp)
                    )
                }
                if (showStartDatePicker) {
                    AndroidView(
                        factory = { context -> CalendarView(context) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 8.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        update = { calendarView ->
                            calendarView.date = LocalDate.now().toEpochDay() * 24 * 60 * 60 * 1000
                            calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
                                val selectedDate = LocalDate.of(year, month + 1, dayOfMonth)
                                startDate = selectedDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                                showStartDatePicker = false
                            }
                            calendarView.setBackgroundColor(Color.White.toArgb())
                        }
                    )
                }
                Text(
                    text = stringResource(id = R.string.end_date),
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Row(
                    modifier = Modifier
                        .border(
                            color = borderColor,
                            width = 1.dp,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            showEndDatePicker = true
                            showStartDatePicker = false
                        },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = endDate.ifEmpty { stringResource(id = R.string.select_end_date) },
                        color = LightGrey,
                        fontSize = 16.sp
                    )
                    Image(
                        painter = painterResource(id = R.drawable.calendar),
                        contentDescription = "calendarIcon",
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
            if (showEndDatePicker) {
                AndroidView(
                    factory = { context -> CalendarView(context) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 8.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    update = { calendarView ->
                        calendarView.date = LocalDate.now().toEpochDay() * 24 * 60 * 60 * 1000
                        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
                            val selectedDate = LocalDate.of(year, month + 1, dayOfMonth)
                            endDate = selectedDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                            showEndDatePicker = false
                        }
                        calendarView.setBackgroundColor(Color.White.toArgb())
                    }
                )
            }
            HorizontalDivider(
                color = LightGrey,
                thickness = 1.dp,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp)
            )
            BlueButton(
                text = stringResource(id = R.string.submit),
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                    .fillMaxWidth(),
                enabled = true
            ) {
                if ((startDate.isNotEmpty() && endDate.isNotEmpty())) {
                    isSheetOpened = false
                } else {
                    borderColor = Color.Red
                }
            }
        }
    }
}