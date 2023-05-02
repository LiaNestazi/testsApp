package com.example.testsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testsapp.models.User
import com.example.testsapp.ui.composables.AccountPage
import com.example.testsapp.ui.theme.TestsAppTheme

class AccountActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestsAppTheme {
                var user = User("","Анастасия","lidzhigoriaeva@gmail.com", "Lia","",1,"","")
                AccountPage(user)
            }
        }
    }
}
