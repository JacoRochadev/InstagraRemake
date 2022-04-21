package com.jacorocha.instagram_r.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.jacorocha.instagram_r.R
import com.jacorocha.instagram_r.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginEditEmail.addTextChangedListener(watcher)
        binding.loginEditPassword.addTextChangedListener(watcher)

        binding.loginBtnEnter.setOnClickListener{
            binding.loginBtnEnter.showProgress(true)
            binding.loginEditEmailInput
                .error = "Esse e-mail é inválido"

            binding.loginEditPasswordInput
                .error = "Senha incorreta"

            Handler(Looper.getMainLooper()).postDelayed({
                binding.loginBtnEnter.showProgress(false)
            }, 2000)
        }
    }
    private val watcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            binding.loginBtnEnter.isEnabled = p0.toString().isNotEmpty()
        }

        override fun afterTextChanged(p0: Editable?) {
        }

    }
}