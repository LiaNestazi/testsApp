package com.example.testsapp.ui.composables

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testsapp.R
import com.example.testsapp.models.NavigationDrawerItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SettingsPage(scope: CoroutineScope, drawerState: DrawerState) {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier.align(Alignment.TopCenter)) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.13f)
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box(contentAlignment = Alignment.CenterEnd,
                        modifier = Modifier.fillMaxWidth(0.14f)){
                        FAB({ scope.launch { drawerState.open() } }, iconResourceId = R.drawable.category)
                    }
                    Box(contentAlignment = Alignment.CenterEnd,
                        modifier = Modifier.fillMaxWidth(0.55f)){
                        Text(
                            "Настройки",
                            fontSize = 20.sp,
                            style = MaterialTheme.typography.h1,
                            modifier = Modifier.padding(top = 8.dp, end = 3.dp)
                        )
                    }
                    Box(contentAlignment = Alignment.CenterEnd,
                        modifier = Modifier.fillMaxWidth(0.35f)
                    ){

                    }
                    Box(contentAlignment = Alignment.CenterEnd,
                        modifier = Modifier.fillMaxWidth(0.55f)
                    ){

                    }
                }
            }
            val accountList = prepareAccountList()
            val helpList = prepareHelpList()

            Column() {
                Text(
                    "Аккаунт",
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(start = 16.dp, bottom = 10.dp)
                )
                OptionsColumn(list = accountList)
                Text(
                    "Помощь",
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(start = 16.dp, bottom = 10.dp)
                )
                OptionsColumn(list = helpList)
            }

        }

        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = colorResource(
                id = R.color.main_orange
            )),
            border = BorderStroke(1.dp, color = colorResource(id = R.color.main_orange)),
            shape = CircleShape,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Text("Выйти",
                fontSize = 16.sp,
                style = MaterialTheme.typography.h1,
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }

    }


}
@Composable
private fun prepareAccountList(): List<NavigationDrawerItem>{
    val itemsList = arrayListOf<NavigationDrawerItem>()
    itemsList.add(
        NavigationDrawerItem(
            icon = ImageVector.vectorResource(id = R.drawable.profile),
            label = "Аккаунт"
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            icon = ImageVector.vectorResource(id = R.drawable.notification),
            label = "Уведомления"
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            icon = ImageVector.vectorResource(id = R.drawable.password),
            label = "Безопасность"
        )
    )
    return itemsList
}
@Composable
private fun prepareHelpList(): List<NavigationDrawerItem>{
    val itemsList = arrayListOf<NavigationDrawerItem>()
    itemsList.add(
        NavigationDrawerItem(
            icon = ImageVector.vectorResource(id = R.drawable.request),
            label = "Заявки"
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            icon = ImageVector.vectorResource(id = R.drawable.chat),
            label = "Чат с поддержкой"
        )
    )
    return itemsList
}