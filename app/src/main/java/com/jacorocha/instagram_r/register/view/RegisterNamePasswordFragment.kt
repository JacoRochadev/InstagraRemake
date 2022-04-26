package com.jacorocha.instagram_r.register.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jacorocha.instagram_r.R
import com.jacorocha.instagram_r.common.base.DependencyInjector
import com.jacorocha.instagram_r.common.util.TxtWatcher
import com.jacorocha.instagram_r.databinding.FragmentRegisterNamePasswordBinding
import com.jacorocha.instagram_r.register.RegisterNameAndPassword
import com.jacorocha.instagram_r.register.presentation.RegisterNameAndPasswordPresenter
import java.lang.IllegalArgumentException

class RegisterNamePasswordFragment : Fragment(R.layout.fragment_register_name_password), RegisterNameAndPassword.View {

    private var binding: FragmentRegisterNamePasswordBinding? = null

    override lateinit var presenter: RegisterNameAndPassword.Presenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterNamePasswordBinding.bind(view)
        var email = arguments?.getString(KEY_EMAIL) ?: throw IllegalArgumentException("email not found")
        val repository = DependencyInjector.registerEmailRepository()
        presenter = RegisterNameAndPasswordPresenter(this, repository)

        binding?.let {
            with(it){
                registerTxtLogin.setOnClickListener {
                    activity?.finish()
                }
                registerNameBtnNext.setOnClickListener {
                    presenter.create(
                        email,
                        registerEditName.text.toString(),
                        registerEditPassword.text.toString(),
                        registerEditPassword.text.toString()
                    )
                }
                registerEditName.addTextChangedListener(watcher)
                registerEditPassword.addTextChangedListener(watcher)
                registerEditConfirm.addTextChangedListener(watcher)

                registerEditName.addTextChangedListener(TxtWatcher{
                    displayNameFailure(null)
                })
                registerEditPassword.addTextChangedListener(TxtWatcher{
                    displayPasswordFailure(null)
                })
                registerEditConfirm.addTextChangedListener(TxtWatcher{
                    displayPasswordFailure(null)
                })
            }
        }

    }

    private val watcher = TxtWatcher {
        binding?.registerNameBtnNext?.isEnabled = binding?.registerEditName?.text.toString().isNotEmpty()
                && binding?.registerEditPassword?.text.toString().isNotEmpty()
                && binding?.registerEditConfirm?.text.toString().isNotEmpty()
    }


    companion object {
        const val KEY_EMAIL = "key_email"
    }

    override fun showProgress(enabled: Boolean) {
        binding?.registerNameBtnNext?.showProgress(enabled)
    }

    override fun displayNameFailure(nameError: Int?) {
        binding?.registerEditNameInput?.error = nameError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passError: Int?) {
        binding?.registerEditPasswordInput?.error = passError?.let { getString(it) }
    }

    override fun onCreateSuccess(name: String) {
        //TODO: abrir a tela de bem vindo
    }

    override fun onCreateFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        binding = null
        presenter.onDestroy()
        super.onDestroy()
    }
}