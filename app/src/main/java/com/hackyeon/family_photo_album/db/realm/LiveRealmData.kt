package com.hackyeon.family_photo_album.db.realm

import androidx.lifecycle.LiveData
import com.hackyeon.family_photo_album.db.data.User
import io.realm.Realm
import io.realm.RealmChangeListener
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.kotlin.where

class LiveRealmData<T: RealmObject>(private val realmResults: RealmResults<T>): LiveData<RealmResults<T>>() {
    private val listener = RealmChangeListener<RealmResults<T>>{  value = it }
    override fun onActive()  {
        if(realmResults.isValid) {
            realmResults.addChangeListener(listener)
            if(realmResults.isLoaded) {
                value = realmResults
            }
        }
    }
    override fun onInactive() = realmResults.removeChangeListener(listener)
}


@JvmName("DB_list_Helper")
fun <T: RealmObject> RealmResults<T>.asLiveData() = LiveRealmData<T>(this)

fun Realm.UserDao() = UserDao(this)
class UserDao(private val mRealm: Realm) {
    fun getUserLiveData(): LiveData<RealmResults<User>> {
        return mRealm.where<User>()
            .findAll()
            .asLiveData()
    }
}