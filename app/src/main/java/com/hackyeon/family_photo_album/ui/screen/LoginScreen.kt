package com.hackyeon.family_photo_album.ui.screen

import android.text.Editable
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hackyeon.family_photo_album.MainViewModel
import com.hackyeon.family_photo_album.ui.theme.Family_photo_albumTheme

@Composable
fun LoginScreen(viewModel: MainViewModel) {
    val text by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextField(value = id, onValueChange = { id = it }, label = { Text(text = "아이디")})
        TextField(value = password, onValueChange = { password = it }, label = { Text(text = "패스워드")})
        Button(onClick = {
            viewModel.login(id, password)
        }) {
            Text(text = "로그인")
        }
        Button(onClick = {
            viewModel.join(id, password)
        }) {
            Text(text = "회원가입")
        }
        // todo 회원찾기
//        Button(onClick = { /*TODO*/ }) {
//            Text(text = "회원찾기")
//        }

    }
}

@Preview
@Composable
fun DefaultLoginScreen() {
    Family_photo_albumTheme {
        LoginScreen(viewModel = MainViewModel())
    }
}