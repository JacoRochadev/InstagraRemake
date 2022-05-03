package com.jacorocha.instagram_r.splash.data

class SplashRepository(private val dataSource: SplashDataSource) {
    fun session(callback: SplashCallback){
        dataSource.session(callback)
    }
}