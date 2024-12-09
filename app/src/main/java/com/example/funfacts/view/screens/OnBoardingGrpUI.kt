package com.example.funfacts.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfacts.view.onboaring.OnBoardingModel

@Composable
fun OnBoardingGrpUI(onBoardingModel: OnBoardingModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        Spacer(modifier = Modifier.size(246.dp))

        Image(
            painter = painterResource(id = onBoardingModel.image),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 20.dp)
                .size(300.dp, 178.dp)
        )

        Spacer(modifier = Modifier.size(96.dp))

        Text(
            text = "${onBoardingModel.title}",
            modifier = Modifier
                .padding(start = 20.dp)
                .size(227.dp, 88.dp),
            style = TextStyle(
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
            )
        )

        Spacer(modifier = Modifier.size(5.dp))


        Text(
            text = "${onBoardingModel.desc}",
            modifier = Modifier
                .padding(start = 20.dp)
                .size(227.dp, 88.dp),
            style = TextStyle(
                fontSize = 24.sp,
            )
        )
    }
}


@Composable
@Preview
fun OnBoardingGrpUIPreview1() {
    OnBoardingGrpUI(onBoardingModel = OnBoardingModel.FirstPage)
}

@Composable
@Preview
fun OnBoardingGrpUIPreview2() {
    OnBoardingGrpUI(onBoardingModel = OnBoardingModel.SecondPage)
}

@Composable
@Preview
fun OnBoardingGrpUIPreview3() {
    OnBoardingGrpUI(onBoardingModel = OnBoardingModel.ThirdPage)
}