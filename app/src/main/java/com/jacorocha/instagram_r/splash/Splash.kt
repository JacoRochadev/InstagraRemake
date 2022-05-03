package com.jacorocha.instagram_r.splash

import com.jacorocha.instagram_r.common.base.BasePresenter
import com.jacorocha.instagram_r.common.base.BaseView

interface Splash {
    interface Presenter : BasePresenter{
        fun authenticated()
    }
    interface  View:BaseView<Presenter> {
        fun goToMainScreen()
        fun goToLoginScreen()

    }
}