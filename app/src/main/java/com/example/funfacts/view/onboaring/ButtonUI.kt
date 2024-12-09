package com.example.funfacts.view.onboaring

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.funfacts.R

@Composable
fun RoundButtonWithContent(
    backgroundColor: Color = Color.Black, // Button background color
    contentColor: Color = Color.White, // Content (image/icon) tint color
    buttonSize: Dp = 60.dp, // Size of the circular button
    contentSize: Dp = 30.dp, // Size of the image/icon content
    painter: Painter? = null, // Custom painter for image or icon
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        shape = RoundedCornerShape(50), // Circular shape
        modifier = Modifier.size(buttonSize) // Equal width and height for the button
    ) {
        if (painter != null) {
            // Display custom image or icon
            Image(
                painter = painter,
                contentDescription = "Button Content",
                modifier = Modifier.size(contentSize), // Set size for the content
                colorFilter = ColorFilter.tint(contentColor) // Tint the image if needed
            )
        } else {
            // Fallback: display a default icon or text
            Icon(
                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                contentDescription = "Arrow Icon",
                tint = contentColor,
                modifier = Modifier.size(contentSize)
            )
        }
    }
}


@Preview
@Composable
fun NextButton() {

    RoundButtonWithContent(
        buttonSize = 60.dp, // Optional: Increase button size if needed
        onClick = { /* Perform navigation or action */ },
        painter = painterResource(id = R.drawable.right_arrow)
    )
}

