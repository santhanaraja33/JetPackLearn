package com.example.funfacts.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.funfacts.util.Constants
import kotlinx.coroutines.launch

@Composable
fun BottomNavigationBar(navController: NavHostController, pagerState: PagerState) {

    NavigationBar(
        containerColor = Color(0xFF0F9D58), // Background color
        tonalElevation = 4.dp, // Optional: Add elevation (shadow)
        modifier = Modifier.height(70.dp) // Change height of the NavigationBar
    ) {
        // Observe the backstack
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        // Get the current route
        val currentRoute = navBackStackEntry?.destination?.route

        val coroutineScope = rememberCoroutineScope()


        // Iterate through the bottom nav items
        Constants.BottomNavItems.forEachIndexed { index, navItem ->

            // Place the bottom nav items
            NavigationBarItem(

                selected = pagerState.currentPage == index,

                // Navigate to the selected route on click
                onClick = {

                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                    
                },

                // Icon of the nav item
                icon = {
                    Icon(
                        imageVector = navItem.icon, contentDescription = navItem.label
                    )
                },

                // Label of the nav item
                label = {
                    Text(text = navItem.label)
                },

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White, // Icon color when selected
                    unselectedIconColor = Color.LightGray, // Icon color when unselected
                    selectedTextColor = Color.White, // Text color when selected
                    unselectedTextColor = Color.LightGray, // Text color when unselected
                    indicatorColor = Color(0xFF2D5E4E) // Background indicator color when selected
                ),

                alwaysShowLabel = true // Always show label, optional
            )
        }
    }
}
