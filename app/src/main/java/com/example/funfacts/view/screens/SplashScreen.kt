package com.example.funfacts.view.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.funfacts.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay

@Composable
fun SplashAnimate(navController: NavController) {
    val scale = remember { Animatable(0f) }
    val systemUiController = rememberSystemUiController()

    LaunchedEffect(key1 = true) {
        systemUiController.isSystemBarsVisible = false
        scale.animateTo(targetValue = 0.5f, animationSpec = tween(durationMillis = 500, easing = {
            OvershootInterpolator(2f).getInterpolation(it)
        }))
        delay(3000L)
        navController.navigate("main") {
            popUpTo("splash") {
                inclusive = true
            }
        }
        systemUiController.isSystemBarsVisible = true

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_android_24),
            contentDescription = "Splash Image",
            modifier = Modifier
                .width(500.dp)
                .height(500.dp)
                .scale(scale.value)
        )
    }


}


@Composable
@Preview
fun SplashPreview() {
    SplashAnimate(navController = NavController(LocalContext.current))

}