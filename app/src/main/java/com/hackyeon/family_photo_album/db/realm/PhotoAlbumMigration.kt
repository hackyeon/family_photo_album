package com.hackyeon.family_photo_album.db.realm

import io.realm.DynamicRealm
import io.realm.RealmMigration

class PhotoAlbumMigration: RealmMigration {
    override fun migrate(realm: DynamicRealm, oldVersion: Long, newVersion: Long) {
        var version = oldVersion
        if(version == 1L) {
            // current
        }
    }
}