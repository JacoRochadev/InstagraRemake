package com.jacorocha.instagram_r.splash.presentetion

import com.jacorocha.instagram_r.splash.Splash
import com.jacorocha.instagram_r.splash.data.SplashCallback
import com.jacorocha.instagram_r.splash.data.SplashRepository

class SplashPresenter(private var view: Splash.View?, private var repository: SplashRepository) : Splash.Presenter{
    override fun onDestroy() {
        view = null
    }

    override fun authenticated() {
        repository.session(object : SplashCallback{
            override fun onSuccess() {
                view?.goToMainScreen()
            }

            override fun onFailure() {
                view?.goToLoginScreen()
            }
        })
    }
}