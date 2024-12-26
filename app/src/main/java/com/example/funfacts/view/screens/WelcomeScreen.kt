package com.example.funfacts.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.funfacts.R

@Composable
fun WelcomeScreen(navController: NavHostController) {


    Scaffold { paddingValues ->
        // Main Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(start = 28.dp, top = 173.dp)
        ) {


            Text(
                text = "Welcome To Home",
                style = TextStyle(
                    color = Color(0xFF252525),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                )
            )

            Spacer(modifier = Modifier.height(72.dp))

            Image(
                modifier = Modifier
                    .width(300.dp)
                    .height(155.dp),
                painter = painterResource(id = R.drawable.welcome_text),
                contentDescription = "welcomeImage"
            )
            

        }

    }
}


@Composable
@Preview
fun WelcomeScreenPreview() {
    WelcomeScreen(navController = NavHostController(LocalContext.current))
}