package com.example.funfacts.view.screens

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.funfacts.view.components.ConfirmationPopup

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search() {

    var showPopup by remember { mutableStateOf(false) }

    var text by remember { mutableStateOf("") }

    var active by remember { mutableStateOf(false) }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

//Search Bar ---- Start
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .semantics { isTraversalGroup = true }) {

            SearchBar(modifier = Modifier.fillMaxWidth(),
                query = text,
                onQueryChange = {
                    text = it
                },
                onSearch = {
                    active = false
                },
                active = active,
                onActiveChange = {
                    active = it
                },
                placeholder = {
                    Text(text = "Enter your query")
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                }) {
            }
        }


//Search Bar ---- End


//PopUp Show Button --- Start
        Button(
            onClick = { showPopup = !showPopup }, // Toggle the popup visibility
            modifier = Modifier
                .width(150.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
        ) {
            Text(text = "Show Popup", color = Color.White)
        }

        // Show the popup if showPopup is true
        if (showPopup) {

            AnimatedVisibility(
                visible = showPopup, enter = scaleIn(), exit = scaleOut()
            ) {
                ConfirmationPopup(onConfirm = {
                    // Handle confirmation action
                    showPopup = false
                }, onDismiss = {
                    // Handle cancel action
                    showPopup = false
                })
            }
        }

//PopUp Show Button --- End
    }
}






