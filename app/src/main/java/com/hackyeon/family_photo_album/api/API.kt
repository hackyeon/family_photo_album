package com.hackyeon.family_photo_album.api

import com.hackyeon.family_photo_album.api.data.req.ReqPhotoJoin
import com.hackyeon.family_photo_album.api.data.req.ReqPhotoLogin
import com.hackyeon.family_photo_album.api.data.res.ResPhotoJoin
import com.hackyeon.family_photo_album.api.data.res.ResPhotoLogin
import com.hackyeon.family_photo_album.api.network.PhotoAlbumNetwork
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class API {

    private val network = PhotoAlbumNetwork().network

    suspend fun login(id: String, password: String): ResPhotoLogin {
        val req = ReqPhotoLogin().apply {
            setData(id, password)
        }
        return network.photoLogin(req)
    }

    suspend fun join(id: String, password: String): ResPhotoJoin {
        val req = ReqPhotoJoin().apply {
            setData(id, password)
        }
        return network.photoJoin(req)
    }


}