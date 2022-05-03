package com.jacorocha.instagram_r.splash.data

import com.jacorocha.instagram_r.common.model.Database

class FakeLocalDataSource : SplashDataSource{
    override fun session(callback: SplashCallback) {
        if (Database.sessionAuth != null){
            callback.onSuccess()
        }else{
            callback.onFailure()
        }
    }
}