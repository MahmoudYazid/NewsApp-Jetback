package com.example.news.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Letest_News() {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .height(50.dp)
    ){
        Row (    modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .fillMaxHeight() ,
            horizontalArrangement = Arrangement.SpaceEvenly
            ){
            Box(

                modifier = Modifier
                .fillMaxHeight()
                .background(Color.Red)
                .weight(1f)){
                Text(text = "Sssssss")
            }

            Box(modifier = Modifier
                .fillMaxHeight()
                .background(Color.Blue)
                .weight(1f)){
                Text(text = "Sssssss")
            }
        }
    }
}