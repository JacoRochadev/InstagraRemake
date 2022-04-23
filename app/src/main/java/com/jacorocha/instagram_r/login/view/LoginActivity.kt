package com.jacorocha.instagram_r.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.jacorocha.instagram_r.R
import com.jacorocha.instagram_r.common.base.DependencyInjector
import com.jacorocha.instagram_r.common.util.TxtWatcher
import com.jacorocha.instagram_r.databinding.ActivityLoginBinding
import com.jacorocha.instagram_r.login.Login
import com.jacorocha.instagram_r.login.data.FakeDataSource
import com.jacorocha.instagram_r.login.data.LoginRepository
import com.jacorocha.instagram_r.login.presentation.LoginPresenter
import com.jacorocha.instagram_r.main.view.MainActivity

class LoginActivity : AppCompatActivity(), Login.View {

    private lateinit var binding: ActivityLoginBinding
    override lateinit var presenter: Login.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = LoginPresenter(this, DependencyInjector.loginRepository())

        binding.loginEditEmail.addTextChangedListener(watcher)
        binding.loginEditEmail.addTextChangedListener(TxtWatcher{
            displayEmailFailure(null)
        })
        binding.loginEditPassword.addTextChangedListener(watcher)
        binding.loginEditPassword.addTextChangedListener(TxtWatcher{
            displayPasswordFailure(null)
        })

        binding.loginBtnEnter.setOnClickListener{
            //chamar o presenter
            presenter.login(binding.loginEditEmail.text.toString(), binding.loginEditPassword.text.toString())
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
    private val watcher = TxtWatcher {
        binding.loginBtnEnter.isEnabled = binding.loginEditEmail.text.toString().isNotEmpty() && binding.loginEditPassword.text.toString().isNotEmpty()
    }

    //metodos da interface
    override fun showProgress(enabled: Boolean) {
        binding.loginBtnEnter.showProgress(true)
    }

    override fun displayEmailFailure(emailErro: Int?) {
        binding.loginEditEmailInput.error = emailErro?.let { getString(it) }
    }

    override fun displayPasswordFailure(passwordErro: Int?) {
        binding.loginEditPasswordInput.error = passwordErro?.let { getString(it) }
    }

    override fun onUserAuthenticated() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    override fun onUserUnauthorized(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}