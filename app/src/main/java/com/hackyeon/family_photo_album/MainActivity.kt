package com.hackyeon.family_photo_album

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hackyeon.family_photo_album.ui.PhotoApp
import com.hackyeon.family_photo_album.ui.screen.LoadingScreen
import com.hackyeon.family_photo_album.ui.theme.Family_photo_albumTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoApp(viewModel) { openPhotoGallery() }
        }
    }


    private fun openPhotoGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        resultPhotoLauncher.launch(intent)
    }

    private var resultPhotoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if(result.resultCode == Activity.RESULT_OK) {
            result.data?.data?.let { uri ->
                CoroutineScope(Dispatchers.IO).launch {
                    val bitmap = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        ImageDecoder.decodeBitmap(ImageDecoder.createSource(contentResolver, uri))
                    } else {
                        MediaStore.Images.Media.getBitmap(contentResolver, uri)
                    }
                    val byteArr =ByteArrayOutputStream().apply {
                        bitmap.compress(Bitmap.CompressFormat.PNG,100,this)
                    }.toByteArray()
                    viewModel.img.postValue(byteArr.toString())
                }

            }
//            if(uri == null) {
//                // todo 실패
//            } else {
//
//                val bitmap = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
//                   ImageDecoder.decodeBitmap(ImageDecoder.createSource(contentResolver, uri))
//                } else {
//                    MediaStore.Images.Media.getBitmap(contentResolver, uri)
//                }
//                val byteArr =ByteArrayOutputStream().apply {
//                    bitmap.compress(Bitmap.CompressFormat.PNG,100,this)
//                }.toByteArray()
//                val bit2 = BitmapFactory.decodeByteArray(byteArr,0 , 100)
//            }
        } else {
        }
    }
}