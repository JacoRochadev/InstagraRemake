package com.jacorocha.instagram_r.register.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jacorocha.instagram_r.R
import com.jacorocha.instagram_r.databinding.ActivityLoginBinding
import com.jacorocha.instagram_r.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = RegisterEmailFragment()

        supportFragmentManager.beginTransaction().apply {
            add(R.id.register_fragment, fragment)
            commit()
        }

    }
}