package com.example.funfacts.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.funfacts.view.screens.MainScreen
import com.example.funfacts.view.screens.SplashAnimate


@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {

    NavHost(
        navController = navController,

        // set the start destination as home
        startDestination = "splash",

        // Set the padding provided by scaffold
        modifier = Modifier.padding(paddingValues = padding),

        builder = {


            //Splash
            composable("splash") {
                SplashAnimate(navController)
            }

            composable("main") {
                MainScreen(navController)
            }
        })
}
