package com.jacorocha.instagram_r.common.model

import java.util.*

object Database {
    val userAuth = hashSetOf<UserAuth>()
    var sessionAuth: UserAuth? = null

    init {
        userAuth.add(UserAuth(UUID.randomUUID().toString(), "a@a.com", "12345678"))
        userAuth.add(UserAuth(UUID.randomUUID().toString(), "b@b.com", "12345678"))
    }
}