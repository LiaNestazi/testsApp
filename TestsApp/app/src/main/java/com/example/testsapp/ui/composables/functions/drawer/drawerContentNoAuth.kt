package com.example.testsapp.ui.composables.functions.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Composable
//private fun DrawerContentNoAuth(
//    itemClick: (String) -> Unit
//){
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(colorResource(id = R.color.custom))
//            .padding(PaddingValues(vertical = 26.dp)),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ){
//        Text(
//            modifier = Modifier
//                .padding(top = 12.dp),
//            text = "Вы не авторизованы!",
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color.Black
//        )
//        Text(
//            modifier = Modifier
//                .padding(top = 12.dp, bottom = 12.dp),
//            text = "Пожалуйста, войдите в аккаунт",
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color.Black
//        )
//        OutlinedTextField(modifier = Modifier.padding(PaddingValues(vertical = 12.dp)),
//            value = "", onValueChange = {/*TODO*/},
//            placeholder = {
//                Text("Электронная почта")
//            })
//        OutlinedTextField(modifier = Modifier.padding(PaddingValues(vertical = 12.dp)),
//            value = "", onValueChange = {/*TODO*/},
//            placeholder = {
//                Text("Пароль")
//            })
//        Button(onClick = { /*TODO*/ },
//            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black, contentColor = Color.White),
//            contentPadding = PaddingValues(all = 12.dp),
//            modifier = Modifier.padding(PaddingValues(vertical = 12.dp))
//        )
//        {
//            Text(text = "Войти",fontSize = 20.sp)
//        }
//    }
//}