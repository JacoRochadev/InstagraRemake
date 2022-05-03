package com.jacorocha.instagram_r.common.base

import com.jacorocha.instagram_r.login.data.FakeDataSource
import com.jacorocha.instagram_r.login.data.LoginRepository
import com.jacorocha.instagram_r.register.data.FakeRegisterDataSource
import com.jacorocha.instagram_r.register.data.RegisterRepository
import com.jacorocha.instagram_r.splash.data.FakeLocalDataSource
import com.jacorocha.instagram_r.splash.data.SplashRepository

object DependencyInjector {

    fun splashRepository() : SplashRepository {
        return SplashRepository(FakeLocalDataSource())
    }

    fun loginRepository() : LoginRepository{
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository() : RegisterRepository{
        return RegisterRepository(FakeRegisterDataSource())
    }
}