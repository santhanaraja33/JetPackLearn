package com.example.funfacts.view.listitem

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfacts.model.UserResponse

@Composable
fun UserListItem(userResponse: UserResponse) {
    Card(
        modifier = Modifier
            .padding(vertical = 3.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(5.dp)),
//        elevation = CardDefaults.cardElevation(
//            defaultElevation = 5.dp
//        ),
    ) {

        Text(
            modifier = Modifier.padding(5.dp),
            text = "ID : ${userResponse.id}",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            modifier = Modifier.padding(5.dp),
            text = "Title : ${userResponse.title}",
            fontSize = 10.sp,
            fontWeight = FontWeight.W200,
            color = Color.Black
        )

    }

}
