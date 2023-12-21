package com.example.news.View

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.unit.dp

@Composable
fun ArticleCoulmn(){
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .fillMaxHeight()
    ){
        Column (    modifier = Modifier
            .padding(5.dp)

            .fillMaxWidth()
            .background(Color.White)
            .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(10.dp)){
            for (x in 1..100 ){
                Card()


            }
        }
    }

}

@Composable
fun Card() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp)) // Adjust the corner radius as needed
            .background(Color.Black)
    ) {
        // Your card content goes here
    }
}
