package com.example.news.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
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
                    .background(Color.White)
                    .weight(1f)){
                Column (

                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,

                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 10.dp)
                ){
                    Text(text = "Latest News", fontWeight = FontWeight.W600, fontSize = 20.sp, color = Color.Black)
                    
                }
            }

            Box(

                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.White)
                    .weight(1f)){
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,


                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(end = 10.dp)
                ){

                    Text(text = "See All", fontWeight = FontWeight.W600, fontSize = 20.sp, color = Color(0xFF0080FF))
                    Icon(

                        Icons.Filled.ArrowForward,
                        "",
                        tint = Color(0xFF0080FF),
                        modifier = Modifier
                            .size(30.dp)
                            .background(Color.White)
                    )
                }
            }
        }
    }
}