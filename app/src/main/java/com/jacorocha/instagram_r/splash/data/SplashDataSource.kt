package com.jacorocha.instagram_r.splash.data


interface SplashDataSource {
    fun session(callback: SplashCallback)
}