package com.example.testsapp.ui.composables.functions

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testsapp.R
import kotlinx.coroutines.launch

//@Composable
//fun drawerAnother(){
//    Row(modifier = Modifier
//        .fillMaxWidth()) {
//        Box(
//            modifier = Modifier
//                .padding(start = 16.dp, top = 26.dp)
//        ) {
//            FAB({ scope.launch { drawerState.close() } }, R.drawable.menu)
//
//        }
//        Spacer(modifier = Modifier.size(32.dp))
//        Header(email = "Test email", login = "Test login", modifier = Modifier
//            .padding(top = 26.dp, start = 20.dp)
//        )
//    }
//    Body(items = Items.values().toList(), ){
//        text.value = when(it){
//            Items.Home ->{
//                it.label
//            }
//            Items.Groups ->{
//                it.label
//            }
//            Items.Tests ->{
//                it.label
//            }
//            Items.Requests ->{
//                it.label
//            }
//            Items.Settings ->{
//                it.label
//            }
//            Items.Logout ->{
//                it.label
//            }
//        }
//        scope.launch {
//            drawerState.close()
//        }
//    }
//}