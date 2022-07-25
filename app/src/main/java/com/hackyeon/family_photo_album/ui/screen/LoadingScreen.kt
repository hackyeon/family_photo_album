package com.hackyeon.family_photo_album.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hackyeon.family_photo_album.ui.theme.Family_photo_albumTheme

@Composable
fun LoadingScreen() {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "로딩 화면테스트")
    }
}

@Preview
@Composable
fun DefaultLoadingScreen() {
    Family_photo_albumTheme {
        LoadingScreen()
    }
}