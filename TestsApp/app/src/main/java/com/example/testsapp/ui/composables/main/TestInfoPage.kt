package com.example.testsapp.ui.composables.main

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testsapp.R
import com.example.testsapp.models.Test
import com.example.testsapp.models.User
import com.example.testsapp.singletone.SingletoneFirebase
import com.example.testsapp.ui.composables.RatingBar

@Composable
fun TestInfoPage(navController: NavHostController, item_id: String?){
    Box(modifier = Modifier.fillMaxSize()) {
        //Поиск в БД тестов по его айди
        val user = remember {
            mutableStateOf(User())
        }
        val test = remember {
            mutableStateOf(Test())
        }
        val user_uid = {
            val current = SingletoneFirebase.instance.auth.currentUser
            if (current != null){
                current.uid
            } else{
                ""
            }
        }

        if (user_uid() != ""){
            SingletoneFirebase.instance.database.getReference("Users").child(user_uid.toString()).get().addOnSuccessListener {
                user.value = it.getValue(User::class.java) as User
            }
        }

        if (item_id != null) {
            SingletoneFirebase.instance.database.getReference("Tests").child(item_id).get().addOnSuccessListener {
                test.value = it.getValue(Test::class.java) as Test
                Log.d("MyTag", test.toString())
            }
        }
        var start = remember {
            if (test.value.start_date == "" || test.value.start_time == "")
                mutableStateOf("Не установлено")
            else
                mutableStateOf(test.value.start_date+" "+test.value.start_time)
        }
        var end = remember {
            if (test.value.end_date == "" || test.value.end_time == "")
                mutableStateOf("Не установлено")
            else
                mutableStateOf(test.value.end_date+" "+test.value.end_time)
        }
        var author = remember {
            if (test.value.author_id == "")
                mutableStateOf("Без автора")
            else
                mutableStateOf(test.value.author_id)
        }
        val results = user.value.results
        var score = -1
        for (result in results){
            if (result.test_uid.equals(test.value.id)){
                score = result.score
            }
        }
        var result = remember {
            if (score != -1){
                mutableStateOf(score.toString())
            } else{
                mutableStateOf("Не пройдено")
            }
        }
        Column(modifier = Modifier.align(Alignment.TopCenter)) {
            com.example.testsapp.ui.composables.functions.Header(navController = navController, title = "Информация о тесте")
            Column(modifier = Modifier
                .padding(horizontal = 16.dp)) {
                Text(text = test.value.name,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(text = test.value.description,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(top = 8.dp),
                    color = colorResource(id = R.color.light_gray)
                )
                Row() {
                    Text(text = "Количество вопросов: ",
                        fontSize = 14.sp,
                        style = MaterialTheme.typography.h1,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(text = test.value.question_count.toString(),
                        fontSize = 14.sp,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                Row() {
                    Text(text = "Дата и время начала: ",
                        fontSize = 14.sp,
                        style = MaterialTheme.typography.h1,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(text = start.value,
                        fontSize = 14.sp,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                Row() {
                    Text(text = "Дата и время окончания: ",
                        fontSize = 14.sp,
                        style = MaterialTheme.typography.h1,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(text = end.value,
                        fontSize = 14.sp,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                Row() {
                    Text(text = "Последний результат: ",
                        fontSize = 14.sp,
                        style = MaterialTheme.typography.h1,
                        modifier = Modifier.padding(top = 24.dp)
                    )
                    Text(text = result.value,
                        fontSize = 14.sp,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(top = 24.dp)
                    )
                }
            }
        }
        Box(modifier = Modifier
            .padding(horizontal = 16.dp)
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .fillMaxHeight(0.15f)){
            Row(modifier = Modifier
                .align(Alignment.TopStart)
                .fillMaxHeight(0.35f)
                .fillMaxWidth(0.5f),
            verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Рейтинг: ",
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(top = 8.dp)
                )
                RatingBar(rating = test.value.rating)
            }
            Row(modifier = Modifier
                .align(Alignment.TopEnd)
                .fillMaxHeight(0.3f)
                .fillMaxWidth(0.5f),
                verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End) {
                Text(text = author.value,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.main_orange), contentColor = Color.White),
                shape = CircleShape,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)) {
                Text("Пройти тест",
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }
        }

    }
}