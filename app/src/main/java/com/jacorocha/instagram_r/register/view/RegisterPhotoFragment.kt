package com.jacorocha.instagram_r.register.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jacorocha.instagram_r.R
import com.jacorocha.instagram_r.common.view.CustomDialog
import com.jacorocha.instagram_r.databinding.FragmentRegisterPhotoBinding

class RegisterPhotoFragment : Fragment(R.layout.fragment_register_photo) {

    private var binding: FragmentRegisterPhotoBinding? = null

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterPhotoBinding.bind(view)

        val customDialog = CustomDialog(requireContext())
        customDialog.setTitle(R.string.app_name)
        customDialog.addButton(R.string.photo, R.string.gallery){
            when(it.id){
                R.string.photo ->{

                }
                R.string.gallery ->{

                }
            }
        }
        customDialog.show()
    }
}