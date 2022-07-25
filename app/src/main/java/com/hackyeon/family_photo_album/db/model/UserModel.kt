package com.hackyeon.family_photo_album.db.model

import com.hackyeon.family_photo_album.db.data.User
import com.hackyeon.family_photo_album.db.realm.RealmRepo
import io.realm.kotlin.where

class UserModel {

    fun getLoginUser(): User?{
        val realm = RealmRepo.realm()?: return null
        return realm.where<User>()
            .findFirst()
            .takeIf { it != null }?.run { realm.copyFromRealm(this) }
    }

    fun setLoginUser(user: User) {
        val realm = RealmRepo.realm()?: return
        realm.executeTransaction{ r ->
            r.where<User>()
                .findAll()
                .deleteAllFromRealm()
            r.insert(user)
        }
    }



}