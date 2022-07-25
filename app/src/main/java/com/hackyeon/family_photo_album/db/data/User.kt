package com.hackyeon.family_photo_album.db.data

import io.realm.RealmObject

open class User: RealmObject() {
    var token: String? = ""
    var userid: String? = ""
}