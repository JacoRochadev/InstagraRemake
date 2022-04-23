package com.jacorocha.instagram_r.common.base

import com.jacorocha.instagram_r.login.data.FakeDataSource
import com.jacorocha.instagram_r.login.data.LoginRepository

object DependencyInjector {
    fun loginRepository() : LoginRepository{
        return LoginRepository(FakeDataSource())
    }
}