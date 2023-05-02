package com.example.testsapp.ui.composables.functions

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

//val scaffoldState = rememberScaffoldState()
//val scope = rememberCoroutineScope()
//Box() {
//    Scaffold(
//        scaffoldState = scaffoldState,
//        drawerContent = {
//            if (!isUserAuthorized){
//                //DrawerContentNoAuth(itemClick = {/*TODO*/})
//            } else{
//                // DrawerContentAuth(itemClick = {/*TODO*/})
//            }
//        },
//        drawerShape = RoundedCornerShape(16.dp),
//        floatingActionButton = {
//            FloatingActionButton(onClick = {
//                scope.launch {
//                    scaffoldState.drawerState.apply {
//                        if (isClosed) open() else close()
//                    }
//                } },
//                backgroundColor = colorResource(id = R.color.custom),
//                modifier = Modifier
//                    .size(85.dp)
//                    .padding(16.dp)
//                    .align(Alignment.TopStart)){
//                Icon(Icons.Rounded.Menu,"", tint = Color.White)
//            }
//        }
//    ) {
//        val pagerState = rememberPagerState()
//        HorizontalPager(
//            pageCount = 4,
//            pageSize = PageSize.Fixed(200.dp)
//        ) { page ->
//            // page content
//        }
//        LazyVerticalStaggeredGrid(
//            columns = StaggeredGridCells.Fixed(2),
//            modifier = Modifier.fillMaxSize(),
//            contentPadding = PaddingValues(16.dp)
//        ){
//            items(items){item ->
//                ListOfCards(item = item)
//            }
//        }
//
//    }
//}