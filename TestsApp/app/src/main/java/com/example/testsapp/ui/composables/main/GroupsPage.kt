package com.example.testsapp.ui.composables

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.DrawerState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.testsapp.R
import com.example.testsapp.models.Group
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun GroupsPage(navController: NavHostController, scope: CoroutineScope, drawerState: DrawerState){
    Column() {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.13f)
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
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
        val items = listOf(
            Group("","ИКБО-06-19","creator_1"), 
            Group("","ИКБО-07-19","creator_2"),
            Group("","ИКБО-08-19","creator_3"))
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)) {
            items(items){item ->
                GroupCard(navController = navController, group = item)
            }
            
            
        }
    }


}

@Composable
fun GroupCard(navController: NavHostController, group: Group){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                val group_id = group.id
                navController.navigate("GroupInfoPage")
                       },
        elevation = 5.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = group.name,
                fontSize = 16.sp,
                style = MaterialTheme.typography.h1,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(text = group.creator_id,
                fontSize = 14.sp,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(top = 8.dp),
                color = colorResource(id = R.color.light_gray)
            )
        }

    }
}