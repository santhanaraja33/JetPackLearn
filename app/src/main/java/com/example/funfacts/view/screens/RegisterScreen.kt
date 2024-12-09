package com.example.funfacts.view.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Composable
fun RegisterScreen(navHostController: NavHostController) {
    Text(text = "RegisterScreen")

}


@Composable
@Preview
fun RegisterPreview() {
    RegisterScreen(navHostController = NavHostController(LocalContext.current))
}