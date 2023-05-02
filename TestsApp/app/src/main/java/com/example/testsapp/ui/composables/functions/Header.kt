package com.example.testsapp.ui.composables.functions

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testsapp.R
import com.example.testsapp.ui.composables.FAB

@Composable
fun Header(activity: Activity?, title: String){
    Box(
        modifier = Modifier
            .fillMaxHeight(0.13f)
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(contentAlignment = Alignment.CenterStart,
                modifier = Modifier.fillMaxWidth(0.14f)){
                FAB({activity?.finish()}, iconResourceId = R.drawable.arrow_left)
            }
            Spacer(modifier = Modifier.size(4.dp))
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth(0.8f)){
                Text(
                    title,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h1
                )
            }
        }
    }
}