package com.example.testsapp.ui.composables.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.Group
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testsapp.R
import com.example.testsapp.models.Group

@Composable
fun GroupInfoPage(navController: NavHostController){
    Column() {
        //Поиск в БД группы по ее айди
        var group = Group("", "ИКБО-06-19", "creator_1")
        com.example.testsapp.ui.composables.functions.Header(navController = navController, title = group.name)
        Column(modifier = Modifier
            .padding(horizontal = 16.dp)) {
            Text(text = "Информация о группе",
                fontSize = 20.sp,
                style = MaterialTheme.typography.h1,
                modifier = Modifier.padding(top = 8.dp)
            )
            Row() {
                Text(text = "Создатель: ",
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(text = group.creator_id,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.main_orange), contentColor = Color.White),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth()) {
            Text("Список тестов для группы",
                fontSize = 16.sp,
                style = MaterialTheme.typography.h1,
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = colorResource(
                id = R.color.main_orange
            )),
            border = BorderStroke(1.dp, color = colorResource(id = R.color.main_orange)),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth()
        ) {
            Text("Выйти из группы",
                fontSize = 16.sp,
                style = MaterialTheme.typography.h1,
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }

    }
}