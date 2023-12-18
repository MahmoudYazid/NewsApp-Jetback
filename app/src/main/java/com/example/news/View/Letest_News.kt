package com.example.news.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Letest_News() {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)
            .height(30.dp)
    ){
        Row (    modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)
            .fillMaxHeight()){
            Text(text = "sssssssssss")
        }
    }
}