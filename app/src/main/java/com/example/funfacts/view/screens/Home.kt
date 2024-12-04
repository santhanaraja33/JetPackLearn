package com.example.funfacts.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.funfacts.ui.theme.Purple40
import com.example.funfacts.view.listitem.UserListItem
import com.example.funfacts.viewmodel.UserViewModel

@Composable
fun Home(viewModel: UserViewModel = hiltViewModel()) {
    val getAllUserData = viewModel.getUserData.observeAsState(initial = emptyList())
    val isLoading = viewModel.isLoading.observeAsState(initial = false)

    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Purple40)
                    .padding(15.dp)
            ) {
                Text(
                    text = "User Live Data",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            LaunchedEffect(Unit) {
                viewModel.getUserData()
            }

            when {
                isLoading.value -> {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircularProgressIndicator()
                    }
                }

                getAllUserData.value.isNotEmpty() -> {
                    LazyColumn(modifier = Modifier.padding(10.dp)) {
                        items(getAllUserData.value.size) { index ->
                            UserListItem(getAllUserData.value[index])
                        }
                    }
                }

                else -> {
                    Text("No data available", color = Color.Gray)
                }
            }
        }

    }
}







