package com.hackyeon.family_photo_album.ui.screen

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.hackyeon.family_photo_album.MainViewModel
import com.hackyeon.family_photo_album.ui.theme.Family_photo_albumTheme

@Composable
fun PhotoListScreen(viewModel: MainViewModel, photoCallback: () -> Unit) {
    val photoList by viewModel.photoList.observeAsState()
    val img by viewModel.img.observeAsState("")
    LazyRow{

    }

    LazyColumn{
        photoList?.let { list ->
            items(
                items = list
            ) { item ->
                Text(text = item.title)
            }
        }

    }

//    GlideImage(img.toByteArray(),modifier = Modifier.fillMaxSize()) {
//
//    }

//    if(img.isNotBlank()) {
//        Image(
//            painter = rememberImagePainter(),
////            bitmap = BitmapFactory.decodeByteArray(img.toByteArray(), 0, img.toByteArray().size).asImageBitmap(),
//            contentDescription = ""
//        )
//    }

    Button(onClick = photoCallback ) {
        Text(text = "클릭")
    }
    
    
}

@Preview
@Composable
fun DefaultPhotoListScreen() {
    Family_photo_albumTheme {
        PhotoListScreen(viewModel = MainViewModel()) {

        }
    }
}