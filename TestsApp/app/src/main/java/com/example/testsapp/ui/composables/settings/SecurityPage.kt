package com.example.testsapp.ui.composables

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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.testsapp.R
import com.example.testsapp.models.NavigationDrawerItem
import com.example.testsapp.ui.composables.functions.Header
import kotlinx.coroutines.CoroutineScope

@Composable
fun SecurityPage(navController: NavHostController){
    val activity = (LocalContext.current as? Activity)
    Column() {
        Header(navController = navController, title = "Безопасность")
        val securityList = prepareSecurityList()
        OptionsColumn(navController, list = securityList)
    }

}

@Composable
private fun prepareSecurityList(): List<NavigationDrawerItem>{
    val itemsList = arrayListOf<NavigationDrawerItem>()
    itemsList.add(
        NavigationDrawerItem(
            icon = ImageVector.vectorResource(id = R.drawable.password),
            label = "Сменить пароль"
        )
    )
    return itemsList
}