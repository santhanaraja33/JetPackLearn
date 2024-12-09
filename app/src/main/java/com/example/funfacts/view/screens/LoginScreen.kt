package com.example.funfacts.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.funfacts.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navHostController: NavHostController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }


    Scaffold { paddingValues ->
        // Main Content
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            Image(
                alignment = Alignment.Center,
                painter = painterResource(id = R.drawable.login_lead),
                contentDescription = "LeadImage",
                modifier = Modifier
                    .width(500.dp)
                    .height(300.dp)
                    .fillMaxSize()
                    .padding(top = 42.dp, start = 52.dp)
            )

            Box(modifier = Modifier.size(32.dp))

            //Email Box
            Box(
                modifier = Modifier
                    .background(color = Color(0xFFC4C4C4).copy(alpha = .2f))
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 30.dp),
            ) {

                CustomTextFieldWithTrailingIcon(
                    value = email,
                    onValueChange = { email = it },
                    hint = "Enter your name",
                    textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                    hintStyle = TextStyle(color = Color.Gray, fontSize = 16.sp),
                    backgroundColor = Color.White,
                    cornerRadius = 12.dp,
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.mail),
                            contentDescription = "Arrow Icon",
                            tint = Color.Gray,
                            modifier = Modifier.size(24.dp) // Icon size
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }

            Box(modifier = Modifier.size(25.dp))

            //Password Box
            Box(
                modifier = Modifier
                    .background(color = Color(0xFFC4C4C4).copy(alpha = .2f))
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 30.dp),
            ) {

                CustomTextFieldWithTrailingIcon(
                    value = password,
                    onValueChange = { password = it },
                    hint = "Password",
                    textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                    hintStyle = TextStyle(color = Color.Gray, fontSize = 16.sp),
                    backgroundColor = Color.White,
                    cornerRadius = 12.dp,
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.lock),
                            contentDescription = "Arrow Icon",
                            tint = Color.Gray,
                            modifier = Modifier.size(24.dp) // Icon size
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }

            Box(modifier = Modifier.size(17.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
                    .padding(start = 20.dp)
            ) {
                CustomCheckBoxWithLabel()
            }

        }
    }
}


@Composable
fun CustomTextFieldWithTrailingIcon(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String = "",
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
    hintStyle: TextStyle = TextStyle(color = Color.Gray, fontSize = 16.sp),
    backgroundColor: Color = Color(0xFFF5F5F5),
    cornerRadius: Dp = 8.dp,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    Box(
        modifier = modifier
            .background(color = backgroundColor, shape = RoundedCornerShape(cornerRadius))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // BasicTextField with hint and text
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = textStyle,
                singleLine = true,
                modifier = Modifier.weight(1f), // TextField takes up available space
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(text = hint, style = hintStyle)
                    }
                    innerTextField() // Actual text field
                }
            )
            // Add trailing icon if provided
            if (trailingIcon != null) {
                trailingIcon()
            }
        }
    }
}


@Composable
fun CustomCheckBoxWithLabel(
    label: String = "Remember me",
    modifier: Modifier = Modifier,
    initialChecked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    var checked by remember { mutableStateOf(initialChecked) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clickable {
                checked = !checked
                onCheckedChange(checked)
            }
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp)) // Outline
                .clip(RoundedCornerShape(4.dp))
                .background(if (checked) MaterialTheme.colorScheme.primary else Color.Transparent)
        ) {
            if (checked) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_check_box_24),
                    contentDescription = "Checked",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(16.dp) // Adjust icon size
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp)) // Space between checkbox and label

        Text(
            text = label,
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}


@Composable
@Preview
fun LoginPreview() {
    LoginScreen(navHostController = NavHostController(LocalContext.current))
}