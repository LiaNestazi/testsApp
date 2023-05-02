package com.example.testsapp.ui.composables.main

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testsapp.R
import com.example.testsapp.models.Test
import com.example.testsapp.ui.composables.*
import kotlinx.coroutines.launch
import kotlin.random.Random

enum class Items(val label:String, val icon: ImageVector){
    Home(label = "Домашняя страница", Icons.Default.Home),
    Groups(label = "Мои группы", Icons.Default.Group),
    Tests(label = "Мои тесты", Icons.Default.Assignment),
    Requests(label = "Заявки", Icons.Default.Message),
    Settings(label = "Настройки", Icons.Default.Settings),
    Logout(label = "Выйти", Icons.Default.Logout)
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainPage(){
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val itemsList = prepareNavigationDrawerItems()
    var text = remember{
        mutableStateOf("")
    }
    ModalDrawer(
        drawerContent = {
            DrawerContentAuth(itemClick = {
                when(it){
                    "Домашняя страница" ->{
                        navController.navigate("HomePage", navOptions = null)
                    }
                    "Мои группы" ->{
                        navController.navigate("GroupsPage", navOptions = null)
                    }
                    "Мои тесты" ->{
                        navController.navigate("TestsPage", navOptions = null)
                    }
                    "Настройки" ->{
                        navController.navigate("SettingsPage", navOptions = null)
                    }
                }
                scope.launch {
                    drawerState.close()
                }
            })
        },
        drawerState = drawerState
    ) {
        NavHost(
            navController = navController,
            startDestination = "HomePage"
        ){
            composable("HomePage"){
                HomePage(scope, drawerState)
            }
            composable("GroupsPage"){
                GroupsPage(scope, drawerState)
            }
            composable("TestsPage"){
                TestsPage(scope, drawerState)
            }
            composable("RequestsPage"){
                RequestsPage(scope, drawerState)
            }
            composable("SettingsPage"){
                SettingsPage(scope, drawerState)
            }
        }
    }
}

@Composable
private fun Header(email: String, login: String, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.suga),
            contentDescription = "Profile photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(size = 70.dp)
                .clip(shape = CircleShape)
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(login,
            fontSize = 16.sp,
            style = MaterialTheme.typography.h1)
        Text(email,
            fontSize = 14.sp,
            style = MaterialTheme.typography.body1)
    }
}

@Composable
private fun Body(items: List<Items>, onClickItem:(Items) -> Unit){
    Column(modifier = Modifier.padding(8.dp)) {
        items.forEach{
            Row(modifier = Modifier.clickable {
                onClickItem.invoke(it)
            }) {
                Icon(imageVector = it.icon, contentDescription = "Icon")
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = it.label,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.body1)
            }
            Spacer(modifier = Modifier.size(8.dp))
            Divider(color = colorResource(id = R.color.light_gray))
        }
    }
}