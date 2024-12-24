package com.example.funfacts.view.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.funfacts.R
import com.example.funfacts.view.components.OtpTextField
import com.example.funfacts.view.onboaring.RoundButtonWithContent

@Composable
fun VerificationScreen(navController: NavHostController) {

    var otpValue by remember {
        mutableStateOf("")
    }
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

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "email ",
                            style = TextStyle(fontSize = 14.sp, color = Color(0xFF252525))
                        )
                        Text(
                            text = "hemmyhtec@gmail.com", style = TextStyle(
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

                    Spacer(modifier = Modifier.height(50.dp))


                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(38.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        OtpTextField(otpText = otpValue,
                            onOtpTextChange = { value, otpInputFilled ->
                                otpValue = value
                            })
                    }

                    Spacer(modifier = Modifier.height(40.dp))


                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {

                        VerifyButton(label = "Verify")
                    }

                    Spacer(modifier = Modifier.height(62.dp))


                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {

                        Column {
                            Row {
                                Text(
                                    text = "Didn't receive the code? ", style = TextStyle(
                                        fontWeight = FontWeight.Bold, fontSize = 13.sp
                                    )
                                )

                                Text(
                                    modifier = Modifier.clickable {
                                        Log.e(
                                            "TAG", "VerificationScreen"
                                        )
                                    }, text = "Resend Again", style = TextStyle(
                                        fontWeight = FontWeight.Bold, fontSize = 13.sp
                                    )
                                )
                            }

                            Spacer(modifier = Modifier.height(5.dp))


                            Box(
                                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                            ) {

                                Row {
                                    Text(
                                        text = "Request new code in ", style = TextStyle(
                                            fontWeight = FontWeight.Medium,
                                            fontSize = 13.sp,
                                            color = Color(0xFF000000).copy(alpha = .5f)
                                        )
                                    )

                                    Text(
                                        text = "00:30s ", style = TextStyle(
                                            fontWeight = FontWeight.Medium,
                                            fontSize = 13.sp,
                                            color = Color(0xFF000000).copy(alpha = .5f)
                                        )
                                    )
                                }
                            }


                        }

                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 36.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {

                        RoundButtonWithContent(
                            buttonSize = 60.dp,
                            painter = painterResource(id = R.drawable.left_arrow)
                        ) {

                        }

                    }
                }
            }
        }
    }
}

@Composable
fun VerifyButton(
    label: String = "Next",
    onClick: () -> Unit = {},
) {

    Button(
        onClick = onClick,
        modifier = Modifier
            .width(300.dp)
            .height(50.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF6C63FF))

    ) {
        Text(
            text = label, color = Color.White, style = TextStyle(
                fontSize = 20.sp, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center
            )
        )

    }

}


@Composable
@Preview
fun VerificationScreenPreview() {
    VerificationScreen(navController = NavHostController(LocalContext.current))
}