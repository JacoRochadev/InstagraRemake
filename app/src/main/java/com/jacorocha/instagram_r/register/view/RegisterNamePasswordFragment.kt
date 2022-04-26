package com.jacorocha.instagram_r.register.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jacorocha.instagram_r.R
import com.jacorocha.instagram_r.common.base.DependencyInjector
import com.jacorocha.instagram_r.common.util.TxtWatcher
import com.jacorocha.instagram_r.databinding.FragmentRegisterEmailBinding
import com.jacorocha.instagram_r.databinding.FragmentRegisterNamePasswordBinding
import com.jacorocha.instagram_r.register.RegisterEmail
import com.jacorocha.instagram_r.register.presentation.RegisterEmailPresenter

class RegisterNamePasswordFragment : Fragment(R.layout.fragment_register_name_password) {

    private var binding: FragmentRegisterNamePasswordBinding? = null
    private var fragmentAttachListener: FragmentAttachListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterNamePasswordBinding.bind(view)
        var email = arguments?.getString(KEY_EMAIL)

    }
    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    companion object {
        const val KEY_EMAIL = "key_email"
    }
}