package com.hackyeon.family_photo_album.api.network

import com.hackyeon.family_photo_album.PHOTO_DOMAIN
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class PhotoAlbumNetwork {
    // todo header token

    private val logger: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level =HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(logger)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(PHOTO_DOMAIN)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val network = retrofit.create(PhotoAlbumService::class.java)


}