package com.jacorocha.instagram_r.register

import android.net.Uri
import androidx.annotation.StringRes
import com.jacorocha.instagram_r.common.base.BasePresenter
import com.jacorocha.instagram_r.common.base.BaseView

interface RegisterPhoto {

    //camada presenter
    interface Presenter : BasePresenter {
        fun updateUser(photoUri: Uri)
    }

    //camada view
    interface View : BaseView<Presenter> {
        fun showProgress(enabled: Boolean)
        fun onUpdateSuccess(name: String)
        fun onUpdateFailure()
    }
}