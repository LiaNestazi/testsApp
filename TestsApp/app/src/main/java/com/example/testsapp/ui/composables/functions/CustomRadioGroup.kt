package com.example.testsapp.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.testsapp.R

@Composable
fun CustomRadioGroup(options: List<String>) {
    val selectedOption = remember {
        mutableStateOf("")
    }
    val onSelectionChange = { text: String ->
        selectedOption.value = text
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.15f)
            .horizontalScroll(rememberScrollState()),
    ) {
        options.forEach { text ->
            Row(
                modifier = Modifier
                    .padding(
                        all = 6.dp,
                    ),
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.body2.merge(),
                    color = Color.White,
                    modifier = Modifier
                        .clip(
                            shape = RoundedCornerShape(
                                size = 12.dp,
                            ),
                        )
                        .clickable {
                            onSelectionChange(text)
                        }
                        .background(
                            if (text == selectedOption.value) {
                                colorResource(id = R.color.main_orange)
                            } else {
                                colorResource(id = R.color.light_gray)
                            }
                        )
                        .padding(
                            vertical = 10.dp,
                            horizontal = 16.dp,
                        ),
                )
            }
        }
    }
}
