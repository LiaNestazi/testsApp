package com.example.testsapp.ui.composables.main.addtest

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import com.example.testsapp.R
import com.example.testsapp.singletone.SingletoneTypes
import com.example.testsapp.ui.composables.functions.Header
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.DatePickerDefaults
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.TimePickerDefaults
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun TimePage(navController: NavHostController) {
    var startDate by remember {
        val dateFromObject = SingletoneTypes.instance.created_test.start_date
        if (dateFromObject.equals("")){
            mutableStateOf(LocalDate.now())
        } else{
            val localDate = fromStringToLocalDate(SingletoneTypes.instance.created_test.start_date)
            mutableStateOf(localDate)
        }
    }

    var endDate by remember {
        val dateFromObject = SingletoneTypes.instance.created_test.end_date
        if (dateFromObject.equals("")){
            mutableStateOf(startDate)
        } else{
            val localDate = fromStringToLocalDate(SingletoneTypes.instance.created_test.end_date)
            mutableStateOf(localDate)
        }
    }
    val formattedStartDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("dd MMM yyyy")
                .format(startDate)
        }
    }
    val formattedEndDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("dd MMM yyyy")
                .format(endDate)
        }
    }

    var startTime by remember {
        val timeFromObject = SingletoneTypes.instance.created_test.start_time
        if (timeFromObject.equals("")){
            mutableStateOf(LocalTime.now())
        } else{
            val localTime = fromStringToLocalTime(SingletoneTypes.instance.created_test.start_time)
            mutableStateOf(localTime)
        }
    }
    var endTime by remember {
        val timeFromObject = SingletoneTypes.instance.created_test.end_time
        if (timeFromObject.equals("")){
            mutableStateOf(startTime.plusMinutes(1))
        } else{
            val localTime = fromStringToLocalTime(SingletoneTypes.instance.created_test.end_time)
            mutableStateOf(localTime)
        }
    }
    val formattedStartTime by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("HH:mm")
                .format(startTime)
        }
    }
    val formattedEndTime by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("HH:mm")
                .format(endTime)
        }
    }

    val startDateDialogState = rememberMaterialDialogState()
    val endDateDialogState = rememberMaterialDialogState()
    val startTimeDialogState = rememberMaterialDialogState()
    val endTimeDialogState = rememberMaterialDialogState()


    MaterialDialog (
        dialogState = startDateDialogState,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        ),
        backgroundColor = colorResource(id = R.color.main_orange),
        buttons = {
            positiveButton(text = "Ok")
            negativeButton(text = "Отмена")
        }
    ) {
        datepicker(
            initialDate = LocalDate.now(),
            title = "Выберите дату",
            colors = DatePickerDefaults.colors(
                headerBackgroundColor = colorResource(id = R.color.main_orange),
                dateActiveBackgroundColor = colorResource(id = R.color.main_orange),
                dateActiveTextColor = Color.White
            ),
            allowedDateValidator = {
                it.isAfter(LocalDate.now().minusDays(1))
            }
        ) {
            startDate = it
            endDate = it
        }
    }

    MaterialDialog (
        dialogState = endDateDialogState,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        ),
        backgroundColor = colorResource(id = R.color.main_orange),
        buttons = {
            positiveButton(text = "Ok")
            negativeButton(text = "Отмена")
        }
    ) {
        datepicker(
            initialDate = startDate,
            title = "Выберите дату",
            colors = DatePickerDefaults.colors(
                headerBackgroundColor = colorResource(id = R.color.main_orange),
                dateActiveBackgroundColor = colorResource(id = R.color.main_orange),
                dateActiveTextColor = Color.White
            ),
            allowedDateValidator = {
                it.isAfter(startDate.minusDays(1))
            }
        ) {
            endDate = it
        }
    }

    MaterialDialog (
        dialogState = startTimeDialogState,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        ),
        backgroundColor = colorResource(id = R.color.main_orange),
        buttons = {
            positiveButton(text = "Ok")
            negativeButton(text = "Отмена")
        }
    ) {
        timepicker(
            initialTime = LocalTime.now(),
            title = "Выберите время",
            colors = TimePickerDefaults.colors(
                selectorColor = colorResource(id = R.color.main_orange),
                activeTextColor = Color.White
            )
        ) {
            startTime = it
            endTime = it.plusMinutes(1)
        }
    }

    val timeRange: () -> ClosedRange<LocalTime> = {
        if (startDate == endDate){
            startTime..LocalTime.MAX
        } else{
            LocalTime.MIN..LocalTime.MAX
        }
    }

    MaterialDialog (
        dialogState = endTimeDialogState,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        ),
        backgroundColor = colorResource(id = R.color.main_orange),
        buttons = {
            positiveButton(text = "Ok")
            negativeButton(text = "Отмена")
        }
    ) {
        timepicker(
            initialTime = LocalTime.now(),
            title = "Выберите время",
            colors = TimePickerDefaults.colors(
                selectorColor = colorResource(id = R.color.main_orange),
                activeTextColor = Color.White
            ),
            timeRange = timeRange()
        ) {
            endTime = it
        }
    }

    var label = remember {
        mutableStateOf("Время начала и окончания (необязательно)")
    }
    var isError = remember {
        mutableStateOf(false)
    }




    Box(modifier = Modifier.fillMaxSize()) {
        Column() {
            Header(navController = navController, title = "Создание теста")
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    label.value,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h1
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    "Дата начала",
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.h2
                )
                Spacer(modifier = Modifier.size(4.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            startDateDialogState.show()
                        },
                    enabled = false,
                    value = formattedStartDate,
                    onValueChange = {},
                    isError = isError.value,
                    shape = RoundedCornerShape(14.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = colorResource(id = R.color.main_orange),
                        cursorColor = colorResource(id = R.color.main_orange),
                        trailingIconColor = colorResource(id = R.color.main_orange),
                        focusedBorderColor = colorResource(id = R.color.light_gray)
                    )
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    "Время начала",
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.h2
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            startTimeDialogState.show()
                        },
                    enabled = false,
                    value = formattedStartTime,
                    onValueChange = {},
                    isError = isError.value,
                    shape = RoundedCornerShape(14.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = colorResource(id = R.color.main_orange),
                        cursorColor = colorResource(id = R.color.main_orange),
                        trailingIconColor = colorResource(id = R.color.main_orange),
                        focusedBorderColor = colorResource(id = R.color.light_gray)
                    )
                )
                Spacer(modifier = Modifier.size(24.dp))
                Text(
                    "Дата окончания",
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.h2
                )
                Spacer(modifier = Modifier.size(4.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            endDateDialogState.show()
                        },
                    enabled = false,
                    value = formattedEndDate,
                    onValueChange = {},
                    isError = isError.value,
                    shape = RoundedCornerShape(14.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = colorResource(id = R.color.main_orange),
                        cursorColor = colorResource(id = R.color.main_orange),
                        trailingIconColor = colorResource(id = R.color.main_orange),
                        focusedBorderColor = colorResource(id = R.color.light_gray)
                    )
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    "Время окончания",
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.h2
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            endTimeDialogState.show()
                        },
                    enabled = false,
                    value = formattedEndTime,
                    onValueChange = {},
                    isError = isError.value,
                    shape = RoundedCornerShape(14.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = colorResource(id = R.color.main_orange),
                        cursorColor = colorResource(id = R.color.main_orange),
                        trailingIconColor = colorResource(id = R.color.main_orange),
                        focusedBorderColor = colorResource(id = R.color.light_gray)
                    )
                )
            }
        }
        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.18f)
            .align(Alignment.BottomCenter),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    SingletoneTypes.instance.created_test.start_date = ""
                    SingletoneTypes.instance.created_test.end_date = ""
                    SingletoneTypes.instance.created_test.start_time = ""
                    SingletoneTypes.instance.created_test.end_time = ""
                    SingletoneTypes.instance.created_test.creation_date = fromLocalDateToString(LocalDate.now())

                    navController.navigate("PasswordTestPage")
                          },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = colorResource(
                    id = R.color.main_orange
                )),
                border = BorderStroke(1.dp, color = colorResource(id = R.color.main_orange)),
                shape = CircleShape
            ) {
                Text("Не устанавливать время",
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    SingletoneTypes.instance.created_test.start_date = fromLocalDateToString(startDate)
                    SingletoneTypes.instance.created_test.end_date = fromLocalDateToString(endDate)
                    SingletoneTypes.instance.created_test.start_time = fromLocalTimeToString(startTime)
                    SingletoneTypes.instance.created_test.end_time = fromLocalTimeToString(endTime)
                    SingletoneTypes.instance.created_test.creation_date = fromLocalDateToString(LocalDate.now())

                    navController.navigate("PasswordTestPage")
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.main_orange),
                    contentColor = Color.White
                ),
                shape = CircleShape
            ) {
                Text(
                    "Установить время",
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }
        }
    }
}

fun fromLocalDateToString(date: LocalDate): String {
    return DateTimeFormatter.ofPattern("dd MMM yyyy").format(date)
}

fun fromStringToLocalDate(string: String): LocalDate {
    val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy")
    return LocalDate.parse(string, formatter)
}

fun fromLocalTimeToString(time: LocalTime): String {
    return DateTimeFormatter.ofPattern("HH:mm").format(time)
}

fun fromStringToLocalTime(string: String): LocalTime {
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    return LocalTime.parse(string, formatter)
}