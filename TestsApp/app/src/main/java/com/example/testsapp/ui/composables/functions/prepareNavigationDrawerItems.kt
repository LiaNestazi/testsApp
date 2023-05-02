package com.example.testsapp.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testsapp.R
import com.example.testsapp.models.NavigationDrawerItem

@Composable
fun prepareNavigationDrawerItems(): List<NavigationDrawerItem> {
    val itemsList = arrayListOf<NavigationDrawerItem>()

    itemsList.add(
        NavigationDrawerItem(
            icon = ImageVector.vectorResource(id = R.drawable.home),
            label = "Домашняя страница"
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            icon = ImageVector.vectorResource(id = R.drawable.group),
            label = "Мои группы"
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            icon = ImageVector.vectorResource(id = R.drawable.test),
            label = "Мои тесты"
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            icon = ImageVector.vectorResource(id = R.drawable.setting),
            label = "Настройки"
        )
    )

    return itemsList
}

@Composable
fun NavigationListItem(
    item: NavigationDrawerItem,
    itemClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                itemClick()
            }
            .padding(horizontal = 24.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // icon
        Box {
            Icon(item.icon,"", tint = Color.Black)
        }
        // label
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = item.label,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
    }
}