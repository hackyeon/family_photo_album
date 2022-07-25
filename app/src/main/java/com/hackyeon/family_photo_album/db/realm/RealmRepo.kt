package com.hackyeon.family_photo_album.db.realm

import io.realm.Realm

object RealmRepo {
    fun realm(): Realm? = tryOptional { Realm.getDefaultInstance() }

    private inline fun <T> tryOptional(expression: () -> T): T? {
        return try {
            expression()
        } catch (ex: Throwable) {
            null
        }
    }
}