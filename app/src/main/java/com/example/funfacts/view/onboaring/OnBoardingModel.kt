package com.example.funfacts.view.onboaring

import androidx.annotation.DrawableRes
import com.example.funfacts.R

sealed class OnBoardingModel(
    @DrawableRes val image: Int,
    val title: String,
    val desc: String
) {
    data object FirstPage : OnBoardingModel(
        image = R.drawable.onboard_1,
        title = "Explore the \n" +
                "world easily",
        desc = "To your desire"
    )

    data object SecondPage : OnBoardingModel(
        image = R.drawable.onboard_2,
        title = "Reach the unknown spot",
        desc = "To your destination"
    )

    data object ThirdPage : OnBoardingModel(
        image = R.drawable.onboard_3,
        title = "Make connects with explora",
        desc = "To your dream trip"
    )


}