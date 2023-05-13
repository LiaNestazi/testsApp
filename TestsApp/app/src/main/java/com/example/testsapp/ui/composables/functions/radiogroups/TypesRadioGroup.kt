package com.example.testsapp.ui.composables.functions

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
fun TypesRadioGroup(selectedOption: String, isError: MutableState<Boolean>, titles: List<String>, descriptions: List<String>): String{
    val selectedOption = remember {
        mutableStateOf(selectedOption)
    }
    val light_gray = colorResource(id = R.color.light_gray)
    val main_orange = colorResource(id = R.color.main_orange)
    val textColor = remember {
        mutableStateOf(light_gray)
    }
    val onSelectionChange = { text: String ->
        selectedOption.value = text
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
    ) {
        titles.forEach { text ->
            val isSelected = {
                text == selectedOption.value
            }
            val textColor = {
                if (isSelected()) main_orange else light_gray
            }
            Box(modifier = Modifier
                .clickable {
                    onSelectionChange(text)
                //extends with descriptions
            }
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = text,
                    enabled = false,
                    readOnly = true,
                    onValueChange = {},
                    isError = isError.value,
                    shape = RoundedCornerShape(14.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = textColor(),
                        cursorColor = colorResource(id = R.color.main_orange),
                        trailingIconColor = colorResource(id = R.color.main_orange),
                        focusedBorderColor = colorResource(id = R.color.light_gray)
                    )
                )
                RadioButton(modifier = Modifier.align(Alignment.CenterEnd),
                    selected = isSelected(),
                    onClick = { onSelectionChange(text) },
                colors = RadioButtonDefaults.colors(selectedColor = colorResource(id = R.color.main_orange)))
            }
            Spacer(modifier = Modifier.size(16.dp))
        }
    }
    return selectedOption.value
}