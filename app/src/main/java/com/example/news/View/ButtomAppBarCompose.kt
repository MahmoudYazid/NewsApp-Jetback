package com.example.news.View

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
@Composable
fun ButtomAppBarComp() {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()

            .height(150.dp)
            .padding(20.dp)
            .clip(shape = RoundedCornerShape(50.dp, 50.dp, 50.dp, 50.dp)) // Adjust the corner radius as needed

    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(50.dp, 50.dp, 50.dp, 50.dp)) // Adjust the corner radius as needed

                .fillMaxWidth()
                .height(150.dp)
        ) {
            // Your card content goes here
        }
    }
}