package com.jacorocha.instagram_r.register.data

interface RegisterEmailDataSource {
    fun create(email: String, callback: RegisterEmailCallback)
}