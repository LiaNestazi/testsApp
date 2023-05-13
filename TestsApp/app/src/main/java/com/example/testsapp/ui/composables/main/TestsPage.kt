package com.example.testsapp.ui.composables

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.DrawerState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testsapp.R
import com.example.testsapp.models.Test
import com.example.testsapp.singletone.SingletoneTypes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TestsPage(navController: NavHostController, scope: CoroutineScope, drawerState: DrawerState){
    var user = SingletoneTypes.instance.current_user
    // var tests = allTestByUserId(user.id)
    Column(modifier = Modifier.fillMaxSize()) {
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
                        "Мои тесты",
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.h1,
                        modifier = Modifier.padding(top = 8.dp, end = 6.dp)
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

        //experimental
        val items = (1..100).map{
            val random_desc = Random.nextInt(10, 30)
            val random_rating = Random.nextInt(1, 5)
            Test("id $it", "name $it", "desc".repeat(random_desc),"","",0,
                random_rating,"image $it", "author $it")
        }
        //experimental

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(10.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ){
            items(items){item ->
                TestCards(navController, item = item)
            }
        }
    }
}