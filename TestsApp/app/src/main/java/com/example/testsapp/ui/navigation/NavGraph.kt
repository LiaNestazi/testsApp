package com.example.testsapp.ui.navigation

import androidx.compose.material.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.testsapp.viewmodels.ListViewModel
import com.example.testsapp.singletone.SingletoneTypes
import com.example.testsapp.ui.composables.*
import com.example.testsapp.ui.composables.functions.NameTestPage
import com.example.testsapp.ui.composables.main.GroupInfoPage
import com.example.testsapp.ui.composables.main.TestInfoPage
import com.example.testsapp.ui.composables.main.addtest.*
import com.example.testsapp.ui.composables.main.userAuth.RegisterPage
import com.example.testsapp.ui.composables.main.userAuth.SignInPage
import com.example.testsapp.ui.composables.settings.ChangePasswordPage
import com.example.testsapp.ui.composables.settings.NotificationsPage
import com.example.testsapp.viewmodels.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    scope: CoroutineScope,
    drawerState: DrawerState,
    listViewModel: ListViewModel,
    mainViewModel: MainViewModel
){
    NavHost(navController = navController,
        startDestination = "HomePage"
    ){
        composable("HomePage"){
            HomePage(navController, scope, drawerState, listViewModel, mainViewModel)
        }
        composable("GroupsPage"){
            GroupsPage(navController, scope, drawerState)
        }
        composable(
            route = "GroupInfoPage"
        ){
            GroupInfoPage(
                navController = navController
            )
        }
        composable("TestsPage"){
            TestsPage(navController,scope, drawerState)
        }
        composable(
            route = "TestInfoPage/{current}",
            arguments = listOf(
                navArgument("current"){
                    type = NavType.StringType
                },
            )
        ){
            TestInfoPage(navController = navController, item_id = it.arguments?.getString("current"))
        }


        composable("SettingsPage"){
            SettingsPage(navController,scope, drawerState)
        }
        composable("AccountPage"){
            AccountPage(navController = navController, currentUser = SingletoneTypes.instance.current_user)
        }
        composable("NotificationsPage"){
            NotificationsPage(navController)
        }
        composable("SecurityPage"){
            SecurityPage(navController)
        }
        composable("RequestsPage"){
            RequestsPage(navController)
        }
        composable("ChatPage"){
            ChatPage(navController)
        }
        composable("ChangePasswordPage"){
            ChangePasswordPage(navController)
        }


        composable("AddTestPage"){
            NameTestPage(navController)
        }
        composable(route = "DescriptionPage"){
            DescriptionPage(navController)
        }
        composable(route = "TypeTestPage",
        ){
            TypeTestPage(navController)
        }
        composable(route = "ModeTestPage",){
            ModeTestPage(navController)
        }
        composable(route = "QuestionsCountPage",){
            QuestionsCountPage(navController)
        }
        composable(
            route = "NQuestionTypePage/{currentN}",
            arguments = listOf(
                navArgument("currentN"){
                    type = NavType.IntType
                },
            )
        ){
            NQuestionTypePage(
                it.arguments?.getInt("currentN").toString().toInt(),
                navController = navController
            )
        }
        composable(
            route = "NQuestionContentPage/{currentN}",
            arguments = listOf(
                navArgument("currentN"){
                    type = NavType.IntType
                },
            )
        ){
            NQuestionContentPage(
                it.arguments?.getInt("currentN").toString().toInt(),
                navController = navController
            )
        }
        composable(route = "TimePage"){
            TimePage(navController)
        }
        composable(route = "PasswordTestPage"){
            PasswordTestPage(navController)
        }
        composable(route = "SuccessPage"){
            SuccessPage(navController)
        }

        //Authentication
        composable(route = "SignInPage"){
            SignInPage(navController, scope, drawerState)
        }
        composable(route = "RegisterPage"){
            RegisterPage(navController, scope, drawerState)
        }

    }
}