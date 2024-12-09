package com.example.funfacts.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.funfacts.R
import com.example.funfacts.util.OnboardingUtils
import com.example.funfacts.view.onboaring.IndicatorUI
import com.example.funfacts.view.onboaring.OnBoardingModel
import com.example.funfacts.view.onboaring.RoundButtonWithContent
import kotlinx.coroutines.launch


@Composable
fun OnboardingScreen(navHostController: NavHostController) {

    val context = LocalContext.current
    val onboardingUtils = OnboardingUtils(context)

    val pages = listOf(
        OnBoardingModel.FirstPage, OnBoardingModel.SecondPage, OnBoardingModel.ThirdPage
    )

    val pagerState = rememberPagerState(initialPage = 0) {
        pages.size
    }

    val scope = rememberCoroutineScope()

    Scaffold(bottomBar = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 72.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 20.dp),
            ) {
                IndicatorUI(pageSize = pages.size, currentPage = pagerState.currentPage)
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 24.dp),
                contentAlignment = Alignment.CenterEnd

            ) {
                RoundButtonWithContent(
                    buttonSize = 60.dp, // Optional: Increase button size if needed
                    painter = painterResource(id = R.drawable.right_arrow)
                ) {
                    scope.launch {
                        if (pagerState.currentPage < pages.size - 1) {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        } else {
                            navHostController.navigate("login") {
                                popUpTo("onboard") {
                                    inclusive = true
                                }
                            }
                            onboardingUtils.setOnboardingCompleted()
                        }
                    }
                }
            }

        }
    }, content = {
        Column(Modifier.padding(it)) {
            HorizontalPager(state = pagerState) { index ->
                OnBoardingGrpUI(onBoardingModel = pages[index])
            }
        }
    })


}

@Composable
@Preview
fun OnBoardingScreenPreview() {
    OnboardingScreen(navHostController = NavHostController(LocalContext.current))
}