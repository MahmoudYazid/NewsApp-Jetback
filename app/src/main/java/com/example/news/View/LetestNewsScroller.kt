package com.example.news.View

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LetestNewsScroller(){
    val ScrollState = rememberScrollState()
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Red)
            .height(250.dp)
    ){
        Row (    modifier = Modifier
            .horizontalScroll(ScrollState)
            .fillMaxWidth()
            .background(Color.Red)
            .fillMaxHeight()){
            Text(text = "sssssssssss")
        }
    }
}