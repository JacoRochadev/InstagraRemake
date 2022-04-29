package com.jacorocha.instagram_r.register.presentation

import android.net.Uri
import com.jacorocha.instagram_r.R
import com.jacorocha.instagram_r.register.RegisterNameAndPassword
import com.jacorocha.instagram_r.register.RegisterPhoto
import com.jacorocha.instagram_r.register.data.RegisterCallback
import com.jacorocha.instagram_r.register.data.RegisterRepository

class RegisterPhotoPresenter(
    private var view: RegisterPhoto.View?,
    private val repository: RegisterRepository
    ) : RegisterPhoto.Presenter {

    override fun updateUser(photoUri: Uri) {
        view?.showProgress(true)

        repository.updateUser(photoUri, object : RegisterCallback{
            override fun onSuccess() {
                view?.onUpdateSuccess()
            }

            override fun onFailure(message: String) {
                view?.onUpdateFailure(message)
            }

            override fun onComplete() {
                view?.showProgress(false)
            }

        })
    }
    override fun onDestroy() {
        view = null
    }
}