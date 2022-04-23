package com.jacorocha.instagram_r.register.data

import android.os.Handler
import android.os.Looper
import com.jacorocha.instagram_r.common.model.Database

class FakeRegisterEmailDataSource : RegisterEmailDataSource {
    override fun create(email: String, callback: RegisterEmailCallback) {
        Handler(Looper.getMainLooper()).postDelayed({
            val userAuth = Database.userAuth.firstOrNull { email == it.email }

            if(userAuth == null){
                callback.onSuccess()
            }else{
                callback.onFailure("usuário já cadastrado")
            }
            callback.onComplete()
        }, 2000)
    }
}