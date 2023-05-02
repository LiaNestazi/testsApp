package com.example.testsapp.ui.composables

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.DrawerState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testsapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun GroupsPage(scope: CoroutineScope, drawerState: DrawerState){
    Box(
        modifier = Modifier
            .fillMaxHeight(0.13f)
            .fillMaxWidth().padding(start = 16.dp, end = 16.dp),
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
                    "Мои группы",
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            Box(contentAlignment = Alignment.CenterEnd,
                modifier = Modifier.fillMaxWidth(0.35f)
            ){
                var action = {
                    var log = Log.d("MyTag", "search or tune message")
                }
                FAB(action, iconResourceId = R.drawable.filter)
            }
            Box(contentAlignment = Alignment.CenterEnd,
                modifier = Modifier.fillMaxWidth(0.55f)
            ){
                var action = {
                    var log = Log.d("MyTag", "search or tune message")
                }
                FAB(action, iconResourceId = R.drawable.search)
            }
        }
    }
}