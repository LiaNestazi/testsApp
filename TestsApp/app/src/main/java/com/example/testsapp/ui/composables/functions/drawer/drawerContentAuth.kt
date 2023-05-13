package com.example.testsapp.ui.composables

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testsapp.R
import com.example.testsapp.models.User
import com.example.testsapp.singletone.SingletoneFirebase


@Composable
fun DrawerContentAuth(
    itemClick: (String) -> Unit,
    navController: NavHostController
) {
    val sharedPreferences = LocalContext.current.getSharedPreferences("user", Context.MODE_PRIVATE)
    var email = ""
    var password = ""
    val user = remember{
        mutableStateOf(User())
    }
    if (sharedPreferences != null) {
        email = sharedPreferences.getString("email", "").toString()
        password = sharedPreferences.getString("password", "").toString()
    }
    if (!email.equals("") &&!password.equals("")) {
        val mAuth = SingletoneFirebase.instance.auth
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                val userUid = mAuth.currentUser?.uid
                if (userUid != null){
                    SingletoneFirebase.instance.database.getReference("Users").child(userUid).get().addOnSuccessListener {
                        user.value = it.getValue(User::class.java) as User
                        Log.d("MyTag", user.toString())
                    }
                }
            }
        }
        // Отрисовка стандартного содержимого дравера

        val itemsList = prepareNavigationDrawerItems(true)
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(vertical = 36.dp)
        ) {
            item {
                // user's image
                Image(
                    modifier = Modifier
                        .size(size = 100.dp)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.suga),
                    contentDescription = "Profile Image"
                )
                // user's name
                Text(
                    modifier = Modifier
                        .padding(top = 12.dp),
                    text = user.value.login,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )

                // user's email
                Text(
                    modifier = Modifier.padding(top = 8.dp, bottom = 30.dp),
                    text = user.value.email,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
            }

            items(itemsList) { item ->
                NavigationListItem(item = item) {
                    itemClick(item.label)
                }
            }
        }

    } else{
        // Отрисовка поля авторизуйтесь или зарегистрируйтесь
        val itemsList = prepareNavigationDrawerItems(false)
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(vertical = 36.dp)
        ) {
            item {
                Text(
                    modifier = Modifier
                        .padding(top = 12.dp),
                    text = "Вы не авторизованы",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )

                Row() {
                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .clickable {
                                // Переход на страницу авторизации
                                navController.navigate("SignInPage")
                            },
                        text = "Авторизуйтесь",
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.main_orange)
                    )
                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp),
                        text = " или ",
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp
                    )
                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .clickable {
                                // Переход на страницу регистрации
                                navController.navigate("RegisterPage")
                            },
                        text = "зарегистрируйтесь,",
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.main_orange)
                    )
                }
                Text(
                    modifier = Modifier
                        .padding(bottom = 30.dp),
                    textAlign = TextAlign.Center,
                    text = "чтобы получить доступ ко всем функциям приложения",
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )

            }

            items(itemsList) { item ->
                NavigationListItem(item = item) {
                    itemClick(item.label)
                }
            }
        }
    }


}