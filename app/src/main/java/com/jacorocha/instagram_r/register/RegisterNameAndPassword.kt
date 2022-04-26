package com.jacorocha.instagram_r.register

import androidx.annotation.StringRes
import com.jacorocha.instagram_r.common.base.BasePresenter
import com.jacorocha.instagram_r.common.base.BaseView

interface RegisterNameAndPassword {

    //camada presenter
    interface Presenter : BasePresenter {
        fun create(name: String, password: String, confirm: String)
    }

    //camada view
    interface View : BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun displayNameFailure(@StringRes nameError: Int?)
        fun displayPasswordFailure(@StringRes passError: Int?)
        fun onCreateSuccess(name: String)

        fun onCreateFailure(message: String)
    }
}