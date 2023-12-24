package com.example.news.View

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.unit.dp
@Composable
fun ButtomAppBarComp() {
    val UrlHandler = LocalUriHandler.current
    BottomAppBar(

        modifier = Modifier
            .fillMaxWidth()

            .height(150.dp)
            .padding(20.dp)
            .clip(shape = RoundedCornerShape(50.dp, 50.dp, 50.dp, 50.dp)) // Adjust the corner radius as needed

    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ){

            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.White)

            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                    ,verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally


                ) {
                    Icon(

                        Icons.Filled.Favorite,
                        "",
                        tint = Color(0xFFFF3A44),
                        modifier = Modifier
                            .size(50.dp)
                            .background(Color.White)
                    )
                    Text(text = "Favorite")
                }
            }
            Box(

                modifier = Modifier
                    .weight(1f)
                    .background(Color.White)
                    .clickable {
                        UrlHandler.openUri("https://www.linkedin.com/in/mahmoudyazid/")
                    }
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                    ,verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally


                ) {
                    Icon(

                        Icons.Filled.Face,
                        "",
                        tint = Color(0xFFFF3A44),
                        modifier = Modifier
                            .size(50.dp)
                            .background(Color.White)
                    )
                    Text(text = "Profile")
                }
            }


        }
}
}