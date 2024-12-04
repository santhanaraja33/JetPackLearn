package com.example.funfacts.view.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.funfacts.navigation.BottomNavigationBar
import com.example.funfacts.util.Constants

@Composable
fun MainScreen(navController: NavHostController) {
    val navController = rememberNavController()
    val pagerState = rememberPagerState(pageCount = { Constants.BottomNavItems.size })
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val isSplashScreen = currentRoute == "splash"


    Scaffold(
        bottomBar = {
            if (!isSplashScreen) {
                BottomNavigationBar(
                    navController = navController,
                    pagerState = pagerState
                )
            }
        },


        ) { paddingValues ->
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) { page: Int ->
            when (page) {
                0 -> Home() // Replace with your screen
                1 -> Search() // Replace with your screen
                2 -> Profile() // Replace with your screen
            }
        }
    }
}