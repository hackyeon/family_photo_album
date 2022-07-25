package com.hackyeon.family_photo_album.util

import android.content.Context
import android.content.SharedPreferences
import com.hackyeon.family_photo_album.PhotoAlbumApplication

object PreferenceManager {
    val preferences: SharedPreferences =
        PhotoAlbumApplication.instance.getSharedPreferences(PhotoAlbumApplication.instance.packageName, Context.MODE_PRIVATE)


    fun getString(key: String, default: String?): String? {
        return preferences.getString(key, default)
    }

    fun setString(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

}