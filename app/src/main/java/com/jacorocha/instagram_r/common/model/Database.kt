package com.jacorocha.instagram_r.common.model

import java.util.*

object Database {
    val userAuth = hashSetOf<UserAuth>()
    val photos = hashSetOf<Photo>()
    var sessionAuth: UserAuth? = null

    init {
        userAuth.add(UserAuth(UUID.randomUUID().toString(),"UserA", "a@a.com", "12345678"))
        userAuth.add(UserAuth(UUID.randomUUID().toString(),"Userb","b@b.com", "12345678"))
    }
}