package com.example.testsapp.ui.composables.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.navigation.compose.rememberNavController
import com.example.testsapp.R
import com.example.testsapp.viewmodels.ListViewModel
import com.example.testsapp.ui.composables.*
import com.example.testsapp.ui.navigation.SetupNavGraph
import com.example.testsapp.viewmodels.MainViewModel
import kotlinx.coroutines.launch

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
fun MainPage(listViewModel: ListViewModel, mainViewModel: MainViewModel){
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
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
            }, navController)
        },
        drawerState = drawerState
    ) {
        SetupNavGraph(navController = navController, scope = scope, drawerState = drawerState, listViewModel = listViewModel, mainViewModel)
    }
}
