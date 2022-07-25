package com.hackyeon.family_photo_album.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hackyeon.family_photo_album.MainViewModel
import com.hackyeon.family_photo_album.ui.screen.*
import com.hackyeon.family_photo_album.ui.theme.Family_photo_albumTheme

@Composable
fun PhotoApp(viewModel: MainViewModel, photoCallback: () -> Unit) {
    Family_photo_albumTheme {
        val navController = rememberNavController()
        PhotoNavHost(navController, viewModel, photoCallback)
        val screen by viewModel.screenState.observeAsState(Screen.LOADING)
        navController.navigate(screen.name)
    }
}

@Composable
fun PhotoNavHost(navController: NavHostController, viewModel: MainViewModel, photoCallback: () -> Unit) {
    NavHost(
        navController = navController,
        startDestination = Screen.LOADING.name, // todo navi start loading Screen
        ) {
        composable(Screen.LOADING.name) { LoadingScreen() }
        composable(Screen.LOGIN.name) { LoginScreen(viewModel) }
        composable(Screen.PHOTO_LIST.name) { PhotoListScreen(viewModel, photoCallback) }
        composable(Screen.PHOTO_DETAIL.name) { PhotoDetailScreen() }
        composable(Screen.SETTING.name) { SettingScreen() }
    }
}

enum class Screen{
    LOADING,
    LOGIN,
    PHOTO_LIST,
    PHOTO_DETAIL,
    SETTING
}