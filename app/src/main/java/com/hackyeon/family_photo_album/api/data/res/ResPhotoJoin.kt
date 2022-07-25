package com.hackyeon.family_photo_album.api.data.res

class ResPhotoJoin: ResBaseObject() {
    var user_id: String = ""
    var token: String = ""

    override fun toString(): String {
        return "result: ${this.result} code: ${this.error_code} message: ${this.message} id: ${this.user_id} token: ${this.token}"
    }
}