package com.bugsbunny.gouzour.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bugsbunny.gouzour.presentation.screen.HomeScreen
import com.bugsbunny.gouzour.presentation.screen.RegisterScreen
//import com.bugsbunny.gouzour.presentation.screen.LoginScreen
import com.bugsbunny.gouzour.presentation.viewmodel.HomeViewModel
import com.bugsbunny.gouzour.presentation.viewmodel.RegisterViewModel

//import com.bugsbunny.gouzour.presentation.viewmodel.LoginViewModel

@Composable
fun App() {
    val navController = rememberNavController()
    val viewModel = hiltViewModel<HomeViewModel>()

    NavHost(navController = navController, startDestination = "register") {
        composable("register") {
            RegisterScreen(navController)
        }
//        composable("login") {
//            LoginScreen(navController)
//        }
        composable("home") {
            HomeScreen(navController)
        }
    }
}