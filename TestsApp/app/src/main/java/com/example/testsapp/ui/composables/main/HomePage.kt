package com.example.testsapp.ui.composables

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testsapp.R
import com.example.testsapp.sealed.DataState
import com.example.testsapp.viewmodels.ListViewModel
import com.example.testsapp.ui.composables.functions.*
import com.example.testsapp.viewmodels.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomePage(navController: NavHostController, scope: CoroutineScope, drawerState: DrawerState, listViewModel: ListViewModel, mainViewModel: MainViewModel){
    Box(modifier = Modifier.fillMaxSize()){
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
                            "",
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
            Box(modifier = Modifier
                .fillMaxHeight(0.25f)
                .fillMaxWidth()
            ){
                Card(
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = 16.dp)
                        .fillMaxSize(),
                    elevation = 5.dp,
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Image(painter = painterResource(id = R.drawable.background), contentDescription = "", contentScale = ContentScale.Crop)
                    //Text("random text")
                }
            }

            /*
            //experimental
            Row(modifier = Modifier
                .fillMaxHeight(0.07f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text("Режим",
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h1)
                Text("Просмотреть все",
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.body2,
                    color = colorResource(id = R.color.main_orange)
                )
            }

            val list = listOf("Блиц","Опрос","Викторина", "Еще категория", "Еще", "Режим")
            CustomRadioGroup(options = list)
            //experimental
             */


            Row(modifier = Modifier
                .fillMaxHeight(0.07f)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text("Лучшее",
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h1)
                Text("Просмотреть все",
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.body2,
                    color = colorResource(id = R.color.main_orange)
                )
            }

            /*
            //experimental
            val items = (1..100).map{
                val random_desc = Random.nextInt(10, 30)
                val random_rating = Random.nextInt(1, 5)
                Test("id $it", "name $it", "desc".repeat(random_desc),"","",0,
                    random_rating,"image $it", "author $it")
            }
            //experimental
            */

            ShowLazyList(navController = navController, viewModel = mainViewModel)
            //SetData(navController = navController, viewModel = mainViewModel)
        }


        FAB(onClick = { navController.navigate("AddTestPage", navOptions = null) },
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomEnd),
            backgroundColor = colorResource(id = R.color.main_orange),
            contentColor = Color.White,
            iconResourceId = R.drawable.plus)
    }
    
}

@Composable
fun SetData(navController: NavHostController, viewModel: MainViewModel){
    when (viewModel.response.value){
        is DataState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center)
            {
                CircularProgressIndicator(color = colorResource(id = R.color.main_orange))
            }
        }
        is DataState.Success -> {
            ShowLazyList(navController, viewModel)
        }
        is DataState.Failure -> {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center)
            {
                Text(text = "",
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.body2)
            }
        }
        is DataState.Empty -> {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center)
            {
                Text(text = "Здесь пока ничего нет",
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.body2,
                color = colorResource(id = R.color.light_gray))
            }
        }
        else -> {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center)
            {
                Text(text = "Ошибка получения данных",
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.body2,
                    color = Color.Red)
            }
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShowLazyList(navController: NavHostController, viewModel: MainViewModel) {
    viewModel.getTests()

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(10.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ){
            items(viewModel.tests.value){item ->
                TestCards(navController, item = item)
            }
        }
        if (viewModel.tests.value.isEmpty()){
            Text(text = "Здесь пока ничего нет",
                fontSize = 16.sp,
                style = MaterialTheme.typography.body2,
                color = colorResource(id = R.color.light_gray))
        }
    }
}
