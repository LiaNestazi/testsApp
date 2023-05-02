package com.example.testsapp.ui.composables.settings

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testsapp.R
import com.example.testsapp.ui.composables.functions.Header

@Composable
fun NotificationsPage(){
    val activity = (LocalContext.current as? Activity)
    Box(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.Start,
            modifier = Modifier.align(Alignment.TopCenter)) {

            Header(activity = activity, title = "Уведомления")


            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                Text("Тесты",
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h1)
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()) {
                    val commentCheck = remember { mutableStateOf(true) }
                    Text("Комментарии",
                        fontSize = 16.sp,
                        style = MaterialTheme.typography.body2
                    )
                    Switch(
                        checked = commentCheck.value,
                        onCheckedChange = { commentCheck.value = it },
                        colors = SwitchDefaults.colors(checkedThumbColor = Color.White,
                            uncheckedThumbColor = Color.White,
                            checkedTrackColor = colorResource(id = R.color.main_orange),
                            uncheckedTrackColor = colorResource(id = R.color.light_gray),
                            checkedTrackAlpha = 1f
                        ),
                        modifier = Modifier.scale(scaleX = 1.2f, scaleY = 1.2f)
                    )

                }
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()) {
                    val ratingCheck = remember { mutableStateOf(true) }
                    Text("Отзывы",
                        fontSize = 16.sp,
                        style = MaterialTheme.typography.body2
                    )
                    Switch(
                        checked = ratingCheck.value,
                        onCheckedChange = { ratingCheck.value = it },
                        colors = SwitchDefaults.colors(checkedThumbColor = Color.White,
                            uncheckedThumbColor = Color.White,
                            checkedTrackColor = colorResource(id = R.color.main_orange),
                            uncheckedTrackColor = colorResource(id = R.color.light_gray),
                            checkedTrackAlpha = 1f
                        ),
                        modifier = Modifier.scale(scaleX = 1.2f, scaleY = 1.2f)
                    )
                }
                Text("Сообщения",
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h1)
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()) {
                    val messageCheck = remember { mutableStateOf(true) }
                    Text("Новые сообщения",
                        fontSize = 16.sp,
                        style = MaterialTheme.typography.body2
                    )
                    Switch(
                        checked = messageCheck.value,
                        onCheckedChange = { messageCheck.value = it },
                        colors = SwitchDefaults.colors(checkedThumbColor = Color.White,
                            uncheckedThumbColor = Color.White,
                            checkedTrackColor = colorResource(id = R.color.main_orange),
                            uncheckedTrackColor = colorResource(id = R.color.light_gray),
                            checkedTrackAlpha = 1f
                        ),
                        modifier = Modifier.scale(scaleX = 1.2f, scaleY = 1.2f)
                    )
                }
            }

        }
    }
    
}