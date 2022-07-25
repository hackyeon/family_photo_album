package com.hackyeon.family_photo_album

import android.app.Application
import android.content.res.Resources
import com.hackyeon.family_photo_album.db.realm.PhotoAlbumMigration
import io.realm.Realm
import io.realm.RealmConfiguration

class PhotoAlbumApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        init()
        initRealm()
    }

    private fun init() {
        instance = this
        res = resources
    }

    private fun initRealm() {
        val mi = PhotoAlbumMigration()

        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name("hackphoto.realm")
            .schemaVersion(1)
            .migration(mi)
            .build()
        Realm.setDefaultConfiguration(config)

    }

    companion object {
        lateinit var instance: PhotoAlbumApplication
        lateinit var res: Resources
    }
}