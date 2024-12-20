package com.example.funfacts.view.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun VerificationScreen(navController: NavHostController) {
    Scaffold { paddingValues ->
        // Main Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {


            Box(
                modifier = Modifier
                    .padding(top = 94.dp, start = 21.dp)
                    .fillMaxSize()
            ) {

                Column {
                    Text(
                        text = "Almost  there",
                        style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Medium)
                    )

                    Spacer(modifier = Modifier.height(26.dp))

                    Text(
                        text = "Please enter the 6-digit code sent to your",
                        style = TextStyle(fontSize = 14.sp, color = Color(0xFF252525))
                    )

                    Row {
                        Text(
                            text = "email ",
                            style = TextStyle(fontSize = 14.sp, color = Color(0xFF252525))
                        )

                        Text(
                            text = "hemmyhtec@gmail.com",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color(0xFF252525),
                                fontWeight = FontWeight.Bold
                            )
                        )


                        Text(
                            text = " for verification.",
                            style = TextStyle(fontSize = 14.sp, color = Color(0xFF252525))
                        )
                    }
                }


            }


        }
    }
}


@Composable
@Preview
fun VerificationScreenPreview() {
    VerificationScreen(navController = NavHostController(LocalContext.current))
}