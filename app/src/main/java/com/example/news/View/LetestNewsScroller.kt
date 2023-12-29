package com.example.news.View

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.news.Model.AppDatabase
import com.example.news.Model.NewsResponseClass
import com.example.news.Model.articlesDatabaseEntity
import com.example.news.R
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LetestNewsScroller(){


    val NewsState = remember {
        mutableStateOf<NewsResponseClass?>(
            null
        )
    }
    LaunchedEffect(key1 = Unit, {

        NewsState.value = RetrofitInstance.apiService.getAllNews()
        })

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
                NewsState.value?.articles?.map {article->


                    Cardnews(article?.urlToImage.toString(),article?.title.toString(), article?.author.toString(), article?.url.toString())



                }


                // Launch a coroutine using the viewModelScope


        }
    }
}

@Composable
fun Cardnews(img:String,TextAtricle:String,Auther:String,OpenUrl:String) {
    val brightness = -80f
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val uriHandler = LocalUriHandler.current
    val colorMatrix = floatArrayOf(
        1f, 0f, 0f, 0f, brightness,
        0f, 1f, 0f, 0f, brightness,
        0f, 0f, 1f, 0f, brightness,
        0f, 0f, 0f, 1f, 0f
    )
    Box(
        modifier = Modifier

            .width(350.dp)
            .fillMaxHeight()
            .clickable {
                uriHandler.openUri(OpenUrl)
            }

            .clip(
                shape = RoundedCornerShape(
                    15.dp,
                    15.dp,
                    15.dp,
                    15.dp
                )
            ) // Adjust the corner radius as needed
            .paint(painterResource(id = R.drawable.blackimage), contentScale = ContentScale.FillHeight)

    ) {
        AsyncImage(
            model = img,

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

                Icons.Filled.Favorite,
                "",
                tint = Color(0xFFFF3A44),
                modifier = Modifier
                    .size(30.dp)
                    .background(Color.Transparent)
                    .clickable {

                        val database = AppDatabase.getInstance(context.applicationContext)
                        val articleDao = database.ArticleDaoFunction()
                        scope.launch {
                            val newArticle = articlesDatabaseEntity(
                                img = img.toString(),
                                title = TextAtricle.toString(),
                                link = OpenUrl.toString(),
                                id = null

                            )

                            articleDao.insertAll(newArticle)
                        }

                    }

            )
            Text(text =Auther ,

                fontWeight = FontWeight.W500,
                color = Color.White,

                fontSize = 18.sp,



                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )
            Text(text =TextAtricle ,

                fontWeight = FontWeight.W800,
                color = Color.White,

                fontSize = 27.sp,



                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )
        }

        // Your card content goes here
    }
}
