package com.jacorocha.instagram_r.splash.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.jacorocha.instagram_r.R
import com.jacorocha.instagram_r.common.base.DependencyInjector
import com.jacorocha.instagram_r.common.extension.animationEnd
import com.jacorocha.instagram_r.databinding.ActivitySplashBinding
import com.jacorocha.instagram_r.login.view.LoginActivity
import com.jacorocha.instagram_r.main.view.MainActivity
import com.jacorocha.instagram_r.splash.Splash
import com.jacorocha.instagram_r.splash.presentetion.SplashPresenter

class SplashActivity : AppCompatActivity(), Splash.View {
    private lateinit var binding: ActivitySplashBinding
    override lateinit var presenter: Splash.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = DependencyInjector.splashRepository()
        presenter = SplashPresenter(this, repository)

        binding.splashImg.animate().apply {
            setListener(animationEnd {
                presenter.authenticated()
            })
            duration = 1000
            alpha(1.0f)
            start()
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun goToMainScreen() {
        binding.splashImg.animate().apply {
            setListener(animationEnd {
                val intent = Intent(baseContext, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            })
            duration = 1000
            startDelay = 1000
            alpha(0.0f)
            start()
        }
    }

    override fun goToLoginScreen() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }


}