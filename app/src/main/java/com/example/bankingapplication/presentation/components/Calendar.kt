//
//import android.os.Build
//import android.widget.CalendarView
//import androidx.annotation.RequiresApi
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Divider
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.ModalBottomSheet
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.toArgb
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.viewinterop.AndroidView
//import androidx.navigation.NavHostController
//import java.time.LocalDate
//import java.time.format.DateTimeFormatter
//
//@RequiresApi(Build.VERSION_CODES.O)
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun FilterTransactionsScreen(
//    onDismissRequest: () -> Unit,
//    navController: NavHostController
//) {
//    var startDate by remember { mutableStateOf("") }
//    var endDate by remember { mutableStateOf("") }
//    var showStartDatePicker by remember { mutableStateOf(false) }
//    var showEndDatePicker by remember { mutableStateOf(false) }
//    val isEndDateBeforeStartDate =
//        startDate.isNotEmpty() && endDate.isNotEmpty() && LocalDate.parse(endDate)
//            .isBefore(LocalDate.parse(startDate))
//ModalBottomSheet(
//onDismissRequest = onDismissRequest,
//containerColor = Color.Black
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//    ) {
//        Text(
//            text = stringResource(id = R.string.filterByDateText),
//            style = Typography.titleLarge,
//            color = Color.White,
//            modifier = Modifier.padding(bottom = 32.dp)
//        )
//        Text(
//            text = stringResource(id = R.string.startDateText),
//            color = Color.White,
//            style = Typography.titleSmall
//        )
//        OutlinedTextField(
//            value = startDate,
//            onValueChange = { startDate = it },
//            modifier = Modifier
//                .fillMaxWidth(),
//            placeholder = {
//                Text(text = stringResource(id = R.string.selectStartDayText))
//            },
//            trailingIcon = {
//                Icon(
//                    painter = painterResource(id = R.drawable.baseline_calendar_month_24),
//                    contentDescription = null,
//                    tint = Color.White,
//                    modifier = Modifier.clickable { showStartDatePicker = true }
//                )
//            },
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                focusedBorderColor = Color.White,
//                cursorColor = Color.White,
//                unfocusedTextColor = Color.LightGray,
//                focusedTextColor = Color.LightGray,
//                errorBorderColor = if (startDate.isEmpty()) Color.Red else Color.LightGray
//            ),
//            shape = RoundedCornerShape(8.dp),
//            isError = startDate.isEmpty(),
//            singleLine = true
//        )
//        if (showStartDatePicker) {
//            AndroidView(
//                factory = { context -> CalendarView(context) },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 5.dp, bottom = 5.dp)
//                    .clip(RoundedCornerShape(8.dp)),
//                update = { calendarView ->
//                    calendarView.date = LocalDate.now().toEpochDay() * 24 * 60 * 60 * 1000
//                    calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
//                        val selectedDate = LocalDate.of(year, month + 1, dayOfMonth)
//                        startDate =
//                            selectedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
//                        showStartDatePicker = false
//                    }
//                    calendarView.setBackgroundColor(CardBackground.toArgb())
//                }
//            )
//        }
//        Text(
//            text = stringResource(id = R.string.endDateText),
//            color = Color.White,
//            style = Typography.titleSmall,
//            modifier = Modifier.padding(top = 16.dp)
//        )
//        OutlinedTextField(
//            value = endDate,
//            onValueChange = { endDate = it },
//            modifier = Modifier
//                .fillMaxWidth()
//                .clickable {
//                    showEndDatePicker = true
//                },
//            placeholder = {
//                Text(text = stringResource(id = R.string.selectEndDayText))
//            },
//            trailingIcon = {
//                Icon(
//                    painter = painterResource(id = R.drawable.baseline_calendar_month_24),
//                    contentDescription = null,
//                    tint = Color.White,
//                    modifier = Modifier.clickable { showEndDatePicker = true }
//                )
//            },
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                focusedBorderColor = Color.White,
//                cursorColor = Color.White,
//                unfocusedTextColor = Color.LightGray,
//                focusedTextColor = Color.LightGray,
//                errorTextColor = Color.LightGray,
//                errorBorderColor = if (endDate.isEmpty()  isEndDateBeforeStartDate) Color.Red else Color.LightGray
//            ),
//            shape = RoundedCornerShape(8.dp),
//            isError = endDate.isEmpty()  isEndDateBeforeStartDate,
//            singleLine = true
//        )
//        if (showEndDatePicker) {
//            AndroidView(
//                factory = { context -> CalendarView(context) },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 5.dp, bottom = 5.dp)
//                    .clip(RoundedCornerShape(8.dp)),
//                update = { calendarView ->
//                    calendarView.date = LocalDate.now().toEpochDay() * 24 * 60 * 60 * 1000
//                    calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
//                        val selectedDate = LocalDate.of(year, month + 1, dayOfMonth)
//                        endDate = selectedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
//                        showEndDatePicker = false
//                    }
//                    calendarView.setBackgroundColor(CardBackground.toArgb())
//                }
//            )
//        }
//        Divider(
//            color = Color.LightGray,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 16.dp)
//        )
//        Button(
//            onClick = {
//                if (startDate.isNotEmpty() && endDate.isNotEmpty() && isEndDateBeforeStartDate) {
//                    navController.navigate("allTransactions")
//                }
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 16.dp),
//            colors = ButtonDefaults.buttonColors(
//                containerColor = if (startDate.isEmpty()  endDate.isEmpty()  isEndDateBeforeStartDate) ErrorButtonBackground else ButtonBackground,
//                contentColor = Color.White
//            ),
//            shape = RoundedCornerShape(10.dp),
//        ) {
//            Text(text = stringResource(id = R.string.okayButtonText))
//        }
//    }
//}
//}