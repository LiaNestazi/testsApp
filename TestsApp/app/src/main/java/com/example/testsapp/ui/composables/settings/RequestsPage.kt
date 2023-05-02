package com.example.testsapp.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.DrawerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import kotlinx.coroutines.CoroutineScope

@Composable
fun RequestsPage(scope: CoroutineScope, drawerState: DrawerState){
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Requests Page")
    }
}