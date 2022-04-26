package com.jacorocha.instagram_r.register.data

import android.os.Handler
import android.os.Looper
import com.jacorocha.instagram_r.common.model.Database
import com.jacorocha.instagram_r.common.model.UserAuth
import java.util.*

class FakeRegisterDataSource : RegisterDataSource {
    override fun create(email: String, callback: RegisterCallback) {
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

    override fun create(email: String, name: String, password: String, callback: RegisterCallback) {
        Handler(Looper.getMainLooper()).postDelayed({
            val userAuth = Database.userAuth.firstOrNull { email == it.email }

            if(userAuth == null){
                val created = Database.userAuth.add(
                    UserAuth(UUID.randomUUID().toString().toString(), name, email, password)
                )
                if(created){
                    callback.onSuccess()
                } else{
                    callback.onFailure("Erro no servidor")
                }

            }else{
                callback.onFailure("usuário já cadastrado")
            }
            callback.onComplete()
        }, 2000)
    }
}