package com.example.news.View

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.news.Model.AppDatabase
import com.example.news.Model.NewsResponseClass
import com.example.news.Model.articlesDao
import com.example.news.Model.articlesDatabaseEntity
import com.example.news.R

import com.example.news.View.ui.theme.NewsTheme
import kotlinx.coroutines.launch


class FavoriteCartView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Scaffold (
                bottomBar = {

                    ButtomAppBarFavorit()
                }
            ){it
                val context = LocalContext.current
                val scope = rememberCoroutineScope()
                val DataAllNews = remember {
                    mutableStateOf<List<articlesDatabaseEntity>?>(
                        null
                    )
                }
                LaunchedEffect(key1 = Unit, block ={
                    val database = AppDatabase.getInstance(context.applicationContext)
                    val articleDao = database.ArticleDaoFunction()
                    DataAllNews.value = articleDao.getAll()



                } )
                NewsTheme {
                    // A surface container using the 'background' color from the theme
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .fillMaxHeight()
                    ){
                        Column (    modifier = Modifier
                            .padding(5.dp)
                            .verticalScroll(rememberScrollState())
                            .fillMaxWidth()
                            .background(Color.White)
                            .fillMaxHeight(),
                            verticalArrangement = Arrangement.spacedBy(10.dp)){
                            Row (
                                Modifier
                                    .background(Color(0xFFFF3A44))
                                    .fillMaxWidth()
                                    .height(200.dp)
                                , verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ){
                                Icon(

                                    Icons.Filled.Favorite,
                                    "",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(200.dp)
                                        .background(Color.Transparent)


                                )
                            }

                            DataAllNews.value?.map {
                                    item->

                                FavoriteCard(item.img,item.title,item.link,item)

                            }

                            Row (
                                Modifier
                                    .background(Color.White)
                                    .fillMaxWidth()
                                    .height(200.dp)
                                , verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ){
                                Icon(

                                    Icons.Filled.Favorite,
                                    "",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(200.dp)
                                        .background(Color.Transparent)


                                )
                            }

                        }
                    }
                }
            }


        }
    }
}@Composable
fun FavoriteCard(img:String,TextAtricle:String,openUrl:String,OriginalItem:articlesDatabaseEntity) {
    val brightness = -80f
    val uriHandler = LocalUriHandler.current
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val colorMatrix = floatArrayOf(
        1f, 0f, 0f, 0f, brightness,
        0f, 1f, 0f, 0f, brightness,
        0f, 0f, 1f, 0f, brightness,
        0f, 0f, 0f, 1f, 0f
    )
    Box(

        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clickable {
                uriHandler.openUri(openUrl)

            }
            .clip(
                shape = RoundedCornerShape(
                    15.dp,
                    15.dp,
                    15.dp,
                    15.dp
                )
            )
            .paint(
                painterResource(id = R.drawable.blackimage),
                contentScale = ContentScale.FillBounds
            )

    ) {
        Image(
            painter = rememberAsyncImagePainter( img ),
            contentDescription = null,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix))
            ,modifier = Modifier
                .fillMaxHeight()
                .fillMaxSize()
                .blur(15.dp, 15.dp)

                .fillMaxWidth(),
            contentScale = ContentScale.FillHeight
        )
        Column(
            modifier =
            Modifier
                .fillMaxHeight()
                .padding(60.dp)

                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom

        ) {
            Icon(

                Icons.Filled.Close,
                "",
                tint = Color(0xFFFF3A44),
                modifier = Modifier
                    .size(30.dp)
                    .background(Color.Transparent)
                    .clickable {

                        val database = AppDatabase.getInstance(context.applicationContext)
                        val articleDao = database.ArticleDaoFunction()
                        scope.launch {
                            articleDao.delete(OriginalItem)
                        }

                    }

            )

            Text(text =TextAtricle ,

                fontWeight = FontWeight.W800,
                color = Color.White,

                fontSize = 27.sp,



                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )

        }
    }
}
