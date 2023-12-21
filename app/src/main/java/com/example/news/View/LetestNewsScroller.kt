package com.example.news.View

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LetestNewsScroller(){




    val ScrollState = rememberScrollState()
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .height(350.dp)
    ){
        Row (
            horizontalArrangement = Arrangement.spacedBy(5.dp)
            ,modifier = Modifier
            .horizontalScroll(ScrollState)
            .fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 5.dp)

            .background(Color.White)
            .fillMaxHeight()){


            Cardnews()
            Cardnews()
            Cardnews()
            Cardnews()
            Cardnews()


                // Launch a coroutine using the viewModelScope


        }
    }
}

@Composable
fun Cardnews() {
    Box(
        modifier = Modifier
            .width(350.dp)
            .fillMaxHeight()
            .clip(shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp)) // Adjust the corner radius as needed
            .background(Color.Black)
    ) {
        // Your card content goes here
    }
}
