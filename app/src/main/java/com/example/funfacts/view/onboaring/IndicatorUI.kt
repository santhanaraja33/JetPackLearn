package com.example.funfacts.view.onboaring

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun IndicatorUI(
    pageSize: Int,
    currentPage: Int,
    selectedColor: Color = Color(0xFF2F2E41),
    unSelectedColor: Color = Color(0xFF6C63FF),
) {


    Row(horizontalArrangement = Arrangement.SpaceBetween) {

        repeat(pageSize) {
            Box(
                modifier = Modifier
                    .height(6.dp)
                    .padding(start = 2.dp)
                    .width(
                        width = if (it == currentPage) 16.dp else 13.dp
                    )
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = if (it == currentPage) selectedColor else unSelectedColor)
            )
        }
    }
}


@Composable
@Preview
fun IndicatorUIPreview1() {

    IndicatorUI(
        pageSize = 3,
        currentPage = 0,
    )


}


@Composable
@Preview
fun IndicatorUIPreview2() {

    IndicatorUI(
        pageSize = 3,
        currentPage = 1,
    )

}


@Composable
@Preview
fun IndicatorUIPreview3() {

    IndicatorUI(
        pageSize = 3,
        currentPage = 2,
    )

}