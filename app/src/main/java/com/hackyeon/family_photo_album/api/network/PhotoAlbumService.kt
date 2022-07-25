package com.hackyeon.family_photo_album.api.network

import com.hackyeon.family_photo_album.api.data.req.ReqPhotoJoin
import com.hackyeon.family_photo_album.api.data.req.ReqPhotoLogin
import com.hackyeon.family_photo_album.api.data.res.ResPhotoJoin
import com.hackyeon.family_photo_album.api.data.res.ResPhotoLogin
import retrofit2.http.Body
import retrofit2.http.POST

interface PhotoAlbumService {

    @POST("photo_join.php")
    suspend fun photoJoin(@Body req: ReqPhotoJoin): ResPhotoJoin

    @POST("photo_login.php")
    suspend fun photoLogin(@Body req: ReqPhotoLogin): ResPhotoLogin
}