package com.example.news.View

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.findNavController

@OptIn(ExperimentalMaterial3Api::class)

class Home() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Scaffold(
                bottomBar = {

                    ButtomAppBarComp()
                }
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(it)
                        .background(color = Color.White)
                ) {
                    searchBarActivity()
                    Letest_News("Latest News")
                    LetestNewsScroller()
                    Letest_News("All Articles")
                    ArticleCoulmn()
                }
            }
        }
    }
}
