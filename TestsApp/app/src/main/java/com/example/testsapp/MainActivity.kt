package com.example.testsapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.unit.*
import com.example.testsapp.ui.composables.main.MainPage
import com.example.testsapp.ui.theme.TestsAppTheme

@OptIn(ExperimentalFoundationApi::class)
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isUserAuthorized = false
        setContent {
            TestsAppTheme {
                MainPage()
            }
        }
    }
}















