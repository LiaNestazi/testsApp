package com.example.testsapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.unit.*
import androidx.lifecycle.ViewModelProvider
import com.example.testsapp.viewmodels.ListViewModel
import com.example.testsapp.ui.composables.main.MainPage
import com.example.testsapp.ui.theme.TestsAppTheme
import com.example.testsapp.viewmodels.MainViewModel


@OptIn(ExperimentalFoundationApi::class)
class MainActivity : ComponentActivity() {

    val listViewModel: ListViewModel by viewModels()
    val mainViewModel: MainViewModel by viewModels()
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestsAppTheme {
                // check connection
                MainPage(listViewModel, mainViewModel)
            }
        }
    }
}















