package com.jacorocha.instagram_r.register.presentation

import android.util.Patterns
import com.jacorocha.instagram_r.R
import com.jacorocha.instagram_r.common.model.UserAuth
import com.jacorocha.instagram_r.login.Login
import com.jacorocha.instagram_r.login.data.LoginCallback
import com.jacorocha.instagram_r.login.data.LoginRepository
import com.jacorocha.instagram_r.register.RegisterEmail
import com.jacorocha.instagram_r.register.data.RegisterEmailCallback
import com.jacorocha.instagram_r.register.data.RegisterEmailRepository

class RegisterEmailPresenter(
    private var view: RegisterEmail.View?,
    private val repository: RegisterEmailRepository
    ) : RegisterEmail.Presenter {
    override fun create(email: String) {
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        if (!isEmailValid){
            view?.displayEmailFailure(R.string.invalid_email)
        }else{
            view?.displayEmailFailure(null)
        }

        if (isEmailValid){
            view?.showProgress(true)

            repository.create(email, object : RegisterEmailCallback{
                override fun onSuccess() {
                    view?.goToNameAndPasswordScreen(email)
                }

                override fun onFailure(message: String) {
                    view?.onEmailFailure(message)
                }

                override fun onComplete() {
                    view?.showProgress(false)
                }

            })
        }

    }

    override fun onDestroy() {
        view = null
    }
}