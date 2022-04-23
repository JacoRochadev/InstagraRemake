package com.jacorocha.instagram_r.register

import androidx.annotation.StringRes
import com.jacorocha.instagram_r.common.base.BasePresenter
import com.jacorocha.instagram_r.common.base.BaseView

interface RegisterEmail {

    //camada presenter
    interface Presenter : BasePresenter {
        fun create(email: String)
    }

    //camada view
    interface View : BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun onEmailFailure(message: String)
        fun goToNameAndPasswordScreen(email: String)
        fun displayEmailFailure(@StringRes emailError: Int?)
    }
}