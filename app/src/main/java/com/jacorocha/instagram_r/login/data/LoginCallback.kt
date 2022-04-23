package com.jacorocha.instagram_r.login.data

import com.jacorocha.instagram_r.common.model.UserAuth

interface LoginCallback {
    fun onSuccess(userAuth: UserAuth)
    fun onFailure(message: String)
    fun onComplete()
}