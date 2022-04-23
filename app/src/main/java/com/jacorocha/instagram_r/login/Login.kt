package com.jacorocha.instagram_r.login

import com.jacorocha.instagram_r.common.base.BasePresenter
import com.jacorocha.instagram_r.common.base.BaseView

interface Login {

    //camada presenter
    interface Presenter : BasePresenter{
        fun login(email: String, password: String)
    }

    //camada view
    interface View : BaseView<Presenter>{
        fun showProgress(enabled: Boolean)
        fun displayEmailFailure(emailErro: Int?)
        fun displayPasswordFailure(passwordErro: Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized(message: String)
    }
}