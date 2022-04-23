package com.jacorocha.instagram_r.login.data

import javax.security.auth.callback.Callback

interface LoginDataSource {
    fun login(email: String, password: String, callback: LoginCallback)
}