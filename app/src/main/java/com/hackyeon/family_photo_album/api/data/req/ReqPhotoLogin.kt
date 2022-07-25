package com.hackyeon.family_photo_album.api.data.req

class ReqPhotoLogin: ReqBaseObject() {
    var user_id: String = ""
    var user_password: String = ""

    fun setData(id: String, password: String) {
        this.user_id = id
        this.user_password = password
    }

    override val methodName: String
        get() = "photo_login.php"
}