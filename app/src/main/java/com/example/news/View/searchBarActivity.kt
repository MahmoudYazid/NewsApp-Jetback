package com.example.news.View

import android.app.Notification
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Search

import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.news.View.ui.theme.NewsTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import com.google.android.gms.wallet.button.ButtonConstants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun searchBarActivity(){
            var searchText by remember { mutableStateOf("") }
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(vertical = 1.dp)

            ){
            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically

                ,modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()){

                Box(
                    modifier = Modifier
                        .weight(4f)
                        .padding(horizontal = 10.dp)
                ) {
                    TextField(
                        value = searchText,
                        placeholder = { Text("Enter your text") },

                        onValueChange = {
                            searchText = it
                        },
                        trailingIcon = {
                            Icon(
                                Icons.Filled.Search,
                                "",
                                tint = Color.Black,
                                modifier = Modifier.size(25.dp)
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),

                        modifier = Modifier
                            .shadow(3.dp, shape = RoundedCornerShape(50.dp))
                            .border(
                                width = 1.dp,
                                shape = RoundedCornerShape(50.dp, 50.dp, 50.dp, 50.dp),
                                color = Color.Gray
                            )
                            .height(55.dp)
                            .fillMaxWidth()


                            .clip(shape = RoundedCornerShape(50.dp, 50.dp, 50.dp, 50.dp))


                    )
                }

                Box(

                    modifier = Modifier
                        .weight(1f)
                        .padding(1.dp)




                ) {
                    Button(
                        onClick = { /*TODO*/ },


                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF3A44),
                            contentColor = Color.Red),
                                modifier = Modifier
                                .width(70.dp)




                    ) {
                        Row (
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically

                        ){
                            Icon(

                                Icons.Filled.Notifications,
                                "",
                                tint = Color.White,
                                modifier = Modifier
                                    .size(30.dp)
                                    .background(Color(0xFFFF3A44))
                            )
                        }

                    }
                }

            }
            }


}

