package com.example.testsapp.ui.composables

import android.app.Activity
import androidx.activity.OnBackPressedCallback
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testsapp.R
import com.example.testsapp.models.User
import com.example.testsapp.ui.composables.functions.Header
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AccountPage(navController: NavHostController, currentUser: User){
    var name = remember {
        mutableStateOf(currentUser.name)
    }
    var login = remember {
        mutableStateOf(currentUser.login)
    }
    var email = remember {
        mutableStateOf(currentUser.email)
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.align(Alignment.TopCenter)) {

            Header(navController = navController, title = "Аккаунт")

            Box(modifier = Modifier
                .fillMaxHeight(0.33f)) {
                Box(
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = 16.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(0.8f)
                        .clip(RoundedCornerShape(15.dp))
                        .align(Alignment.TopCenter)
                ) {
                    Image(painter = painterResource(id = R.drawable.cover),
                        contentDescription = "Cover",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize())
                    IconButton(
                        onClick = { /*TODO*/ }, modifier = Modifier
                            .padding(12.dp)
                            .clip(shape = CircleShape)
                            .background(Color.White)
                            .align(Alignment.TopEnd)
                            .size(26.dp)
                    ) {
                        Icon(painter = painterResource(id = R.drawable.edit),
                            contentDescription = "Cover Edit", modifier = Modifier.size(22.dp))
                    }
                }
                Box(modifier = Modifier.align(Alignment.BottomCenter)) {
                    Image(
                        modifier = Modifier
                            .size(size = 100.dp)
                            .clip(shape = CircleShape)
                            .align(Alignment.Center),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = R.drawable.suga),
                        contentDescription = "Profile Image")

                    IconButton(
                        onClick = { /*TODO*/ }, modifier = Modifier
                            .clip(shape = CircleShape)
                            .background(Color.White)
                            .align(Alignment.TopEnd)
                            .size(26.dp)
                    ) {
                        Icon(painter = painterResource(id = R.drawable.edit),
                            contentDescription = "Profile Image Edit", modifier = Modifier.size(22.dp))
                    }
                }

            }
            Spacer(modifier = Modifier.size(16.dp))
            Text(currentUser.login,
                fontSize = 20.sp,
                style = MaterialTheme.typography.h1)
            Spacer(modifier = Modifier.size(16.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                value = name.value,
                onValueChange = { name.value = it },
                label = { Text("Имя")},
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = colorResource(id = R.color.main_orange),
                    cursorColor = colorResource(id = R.color.main_orange),
                    trailingIconColor = colorResource(id = R.color.main_orange),
                    focusedBorderColor = colorResource(id = R.color.light_gray),
                    focusedLabelColor = colorResource(id = R.color.main_orange)
                )
            )
            Spacer(modifier = Modifier.size(20.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                value = login.value,
                onValueChange = { login.value = it },
                label = { Text("Имя пользователя") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = colorResource(id = R.color.main_orange),
                    cursorColor = colorResource(id = R.color.main_orange),
                    leadingIconColor = colorResource(id = R.color.main_orange),
                    focusedBorderColor = colorResource(id = R.color.light_gray),
                    focusedLabelColor = colorResource(id = R.color.main_orange)
                )
            )
            Spacer(modifier = Modifier.size(20.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text("Электронная почта") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = colorResource(id = R.color.main_orange),
                    cursorColor = colorResource(id = R.color.main_orange),
                    leadingIconColor = colorResource(id = R.color.main_orange),
                    focusedBorderColor = colorResource(id = R.color.light_gray),
                    focusedLabelColor = colorResource(id = R.color.main_orange)
                )
            )

        }
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.main_orange), contentColor = Color.White),
            shape = CircleShape,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)) {
            Text("Сохранить",
                fontSize = 16.sp,
                style = MaterialTheme.typography.h1,
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }
    }

}