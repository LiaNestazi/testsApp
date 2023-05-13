package com.example.testsapp.ui.composables.main.userAuth

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testsapp.R
import com.example.testsapp.singletone.SingletoneTypes
import com.example.testsapp.ui.composables.functions.Header
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun RegisterPage(navController: NavHostController,
               scope: CoroutineScope,
               drawerState: DrawerState
){
    scope.launch {
        drawerState.close()
    }
    var name = remember{
        mutableStateOf(SingletoneTypes.instance.created_test.name)
    }
    var label = remember {
        mutableStateOf("Введите название")
    }
    var isError = remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier.fillMaxSize()){
        Column() {
            Header(navController = navController, title = "Регистрация")
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    "Создать Новый Аккаунт",
                    fontSize = 40.sp,
                    style = MaterialTheme.typography.h1
                )
                Text("Создайте аккаунт, чтобы сохранять свои результаты и созданные тесты",
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.body1,
                    color = colorResource(id = R.color.light_gray)
                )
                Spacer(modifier = Modifier.size(8.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    value = name.value,
                    onValueChange = {
                        name.value = it
                    },
                    placeholder = {
                        Text("Полное имя",
                            style = MaterialTheme.typography.body1,
                            color = colorResource(id = R.color.light_gray)
                        )},
                    isError = isError.value,
                    shape = RoundedCornerShape(14.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = colorResource(id = R.color.main_orange),
                        cursorColor = colorResource(id = R.color.main_orange),
                        trailingIconColor = colorResource(id = R.color.main_orange),
                        focusedBorderColor = colorResource(id = R.color.light_gray),
                        unfocusedBorderColor = colorResource(id = R.color.light_gray)
                    )
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    value = name.value,
                    onValueChange = {
                        name.value = it
                    },
                    placeholder = {
                        Text("Электронная почта",
                            style = MaterialTheme.typography.body1,
                            color = colorResource(id = R.color.light_gray)
                        )},
                    isError = isError.value,
                    shape = RoundedCornerShape(14.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = colorResource(id = R.color.main_orange),
                        cursorColor = colorResource(id = R.color.main_orange),
                        trailingIconColor = colorResource(id = R.color.main_orange),
                        focusedBorderColor = colorResource(id = R.color.light_gray),
                        unfocusedBorderColor = colorResource(id = R.color.light_gray)
                    )
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    value = name.value,
                    onValueChange = {
                        name.value = it
                    },
                    placeholder = {
                        Text("Пароль",
                            style = MaterialTheme.typography.body1,
                            color = colorResource(id = R.color.light_gray)
                        )},
                    isError = isError.value,
                    shape = RoundedCornerShape(14.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = colorResource(id = R.color.main_orange),
                        cursorColor = colorResource(id = R.color.main_orange),
                        trailingIconColor = colorResource(id = R.color.main_orange),
                        focusedBorderColor = colorResource(id = R.color.light_gray),
                        unfocusedBorderColor = colorResource(id = R.color.light_gray)
                    )
                )
            }
        }

        Column(modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Row (horizontalArrangement = Arrangement.Center){
                Text("Уже есть аккаунт? ",
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.body1
                )
                Text("Авторизуйтесь",
                    modifier = Modifier.clickable {
                        navController.navigate("SignInPage")
                    },
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.h1,
                    color = colorResource(id = R.color.main_orange)
                )
            }
            Button(onClick = {
                if (name.value != ""){
                    SingletoneTypes.instance.created_test.name = name.value
                    navController.navigate("DescriptionPage")
                } else {
                    isError.value = true
                } },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.main_orange), contentColor = Color.White),
                shape = CircleShape,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()) {
                Text("Зарегистрироваться",
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }
        }

    }
}