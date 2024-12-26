package com.example.funfacts.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.funfacts.R

@Composable
fun RegisterScreen(navHostController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
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
                painter = painterResource(id = R.drawable.register_lead),
                contentDescription = "LeadImage",
                modifier = Modifier
                    .width(500.dp)
                    .height(300.dp)
                    .padding(top = 42.dp, start = 52.dp)
            )

            //Name Box
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 30.dp),
            ) {

                CustomText1FieldWithTrailingIcon(
                    value = name,
                    onValueChange = { name = it },
                    hint = "Full name",
                    textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                    hintStyle = TextStyle(color = Color.Gray, fontSize = 16.sp),
                    backgroundColor = Color.White,
                    cornerRadius = 12.dp,
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.user),
                            contentDescription = "Arrow Icon",
                            tint = Color.Gray,
                            modifier = Modifier.size(24.dp) // Icon size
                        )
                    }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }


            Box(modifier = Modifier.size(19.dp))


            //Email Box
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 30.dp),
            ) {

                CustomText1FieldWithTrailingIcon(
                    value = email,
                    onValueChange = { email = it },
                    hint = "Valid email",
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
                    }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }

            Box(modifier = Modifier.size(19.dp))

            //Phone Number Box
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 30.dp),
            ) {

                CustomText1FieldWithTrailingIcon(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    hint = "Phone number",
                    textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                    hintStyle = TextStyle(color = Color.Gray, fontSize = 16.sp),
                    backgroundColor = Color.White,
                    cornerRadius = 12.dp,
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.smartphone),
                            contentDescription = "Arrow Icon",
                            tint = Color.Gray,
                            modifier = Modifier.size(24.dp) // Icon size
                        )
                    }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }

            Box(modifier = Modifier.size(19.dp))

            //Password Box
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 30.dp),
            ) {

                CustomText1FieldWithTrailingIcon(
                    value = password,
                    onValueChange = { password = it },
                    hint = "Strong Password",
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
                    }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }

            Box(modifier = Modifier.size(19.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
                    .padding(start = 20.dp)
            ) {
                CustomCheckBoxWithContent()
                Spacer(modifier = Modifier.height(126.dp))
            }
            NextButton1(label = "Next", onClick = { navHostController.navigate("verification") })
            Box(modifier = Modifier.size(23.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Already a member?  ")
                Text(
                    text = "Log In",
                    color = Color(0xFF6C63FF),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { navHostController.navigate("login") }
                )
            }

        }
    }
}

@Composable
fun CustomText1FieldWithTrailingIcon(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String = "",
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
    hintStyle: TextStyle = TextStyle(color = Color.Gray, fontSize = 16.sp),
    backgroundColor: Color = Color(0xFFE0E0E0), // Updated default color
    cornerRadius: Dp = 8.dp,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions
) {
    Box(
        modifier = modifier.background(
            color = backgroundColor, shape = RoundedCornerShape(cornerRadius)
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = backgroundColor)
        ) {
            // BasicTextField with hint and text
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = textStyle,
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .background(backgroundColor), // TextField takes up available space
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(backgroundColor) // Set the container color
                            .padding(start = 8.dp) // Optional padding
                    ) {
                        if (value.isEmpty()) {
                            Text(
                                text = hint,
                                style = hintStyle,
                                modifier = Modifier
                                    .background(backgroundColor) // Placeholder background color
                            )
                        }
                        innerTextField() // Actual text field
                    }
                },
                keyboardOptions = keyboardOptions
            )
            // Add trailing icon if provided
            if (trailingIcon != null) {
                Box(
                    modifier = Modifier
                        .background(backgroundColor) // Icon background color
                        .padding(end = 8.dp) // Optional padding
                ) {
                    trailingIcon()
                }
            }
        }
    }
}


@Composable
fun CustomCheckBoxWithContent(
    label: String = "Remember me",
    modifier: Modifier = Modifier,
    initialChecked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    var checked by remember { mutableStateOf(initialChecked) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(start = 10.dp)
    ) {
        Box(
            modifier = Modifier
                .size(12.dp)
                .border(1.dp, Color(0xFFCBCBCB), RoundedCornerShape(3.dp)) // Outline
                .clip(RoundedCornerShape(4.dp))
                .clickable {
                    checked = !checked
                    onCheckedChange(checked)
                }
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
            text = "By checking the box you agree to our  ",
            color = Color.Black,
            style = TextStyle(fontSize = 11.sp)
        )

        Text(
            text = "Terms",
            color = Color(0xFF6C63FF),
            style = TextStyle(fontSize = 11.sp)
        )

        Text(
            text = " and",
            color = Color.Black,
            style = TextStyle(fontSize = 11.sp)
        )
        Text(
            text = " Conditions.",
            color = Color(0xFF6C63FF),
            style = TextStyle(fontSize = 11.sp)
        )
    }
}


@Composable
fun NextButton1(
    label: String = "Next",
    onClick: () -> Unit = {},
    icon: Int = R.drawable.baseline_keyboard_arrow_right_24
) {

    Button(
        onClick = onClick, modifier = Modifier
            .width(300.dp)
            .height(50.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF6C63FF))

    ) {
        Row {
            Text(
                text = label,
                color = Color.White,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.width(11.dp))
            Icon(
                painter = painterResource(id = R.drawable.arrow),
                contentDescription = "Checked",
                tint = Color.White,
                modifier = Modifier
                    .size(width = 6.dp, height = 12.dp)
                    .align(Alignment.CenterVertically)// Adjust icon size
            )

        }


    }

}


@Composable
@Preview
fun RegisterPreview() {
    RegisterScreen(navHostController = NavHostController(LocalContext.current))
}