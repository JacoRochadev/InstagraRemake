package com.jacorocha.instagram_r.common.base

import com.jacorocha.instagram_r.login.data.FakeDataSource
import com.jacorocha.instagram_r.login.data.LoginRepository
import com.jacorocha.instagram_r.register.data.FakeRegisterEmailDataSource
import com.jacorocha.instagram_r.register.data.RegisterEmailRepository

object DependencyInjector {
    fun loginRepository() : LoginRepository{
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository() : RegisterEmailRepository{
        return RegisterEmailRepository(FakeRegisterEmailDataSource())
    }
}