package com.hackyeon.family_photo_album.respository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.hackyeon.family_photo_album.api.API
import com.hackyeon.family_photo_album.api.data.res.ResGetPhotoList
import com.hackyeon.family_photo_album.db.Model
import com.hackyeon.family_photo_album.db.data.User
import com.hackyeon.family_photo_album.db.realm.RealmRepo
import com.hackyeon.family_photo_album.db.realm.UserDao
import com.hackyeon.family_photo_album.ui.Screen
import com.hackyeon.family_photo_album.util.SHA256

class PhotoRepository {
    // todo repository
    // get api // get db

    // api
    private val api = API()

    // db
    fun getLoginUser(): User? = Model.user.getLoginUser()

    // test
    val photoList = MutableLiveData<List<ResGetPhotoList>>(
        listOf(
            ResGetPhotoList().apply {
                this.title = "1"
            }   ,
            ResGetPhotoList().apply {
                this.title = "2"
            },
            ResGetPhotoList().apply {
                this.title = "3"
            },
            ResGetPhotoList().apply {
                this.title = "4"
            },
            ResGetPhotoList().apply {
                this.title = "5"
            },
            ResGetPhotoList().apply {
                this.title = "6"
            },
            ResGetPhotoList().apply {
                this.title = "7"
            }
        )
    )

    /**
     * api fun
     */
    suspend fun login(id: String, password: String, successCallback: () -> Unit) {
        val enPassword = SHA256.encryptPassword(password)
        val res = api.login(id, enPassword)

        when(res.result) {
            "OK" -> {
                successCallback()
                val user = User().apply {
                    this.userid = res.user_id
                    this.token = res.token
                }
                Model.user.setLoginUser(user)
            }
            "NK" -> { /*todo error code*/ }
        }
    }

    suspend fun join(id: String, password: String, successCallback: () -> Unit) {
        val enPassword = SHA256.encryptPassword(password)
        val res = api.join(id, enPassword)

        when(res.result) {
            "OK" -> {
                successCallback()
                val user = User().apply {
                    this.userid = res.user_id
                    this.token = res.token
                }
                Model.user.setLoginUser(user)
            }
            "NK" -> { /*todo error toast*/}
        }


    }


    private fun aabb(msg: Any?) {
        Log.d("aabb", "## [${this.javaClass.simpleName}] ## $msg")
    }
}