package com.jacorocha.instagram_r.login

import androidx.annotation.StringRes
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
        fun displayEmailFailure(@StringRes emailErro: Int?)
        fun displayPasswordFailure(@StringRes passwordErro: Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized(message: String)
    }
}