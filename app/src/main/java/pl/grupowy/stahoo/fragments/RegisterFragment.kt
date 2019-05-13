package pl.grupowy.stahoo.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_register_form.*
import pl.grupowy.stahoo.R

class RegisterFragment : BaseFragment() {

    override fun layoutRes(): Int = R.layout.fragment_register_form

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        registerButton.setOnClickListener { attemptRegistration() }
    }

    private fun attemptRegistration() {
        var nickname = nicknameInput.text.toString()
        var email = emailInput.text.toString()
        var password = passwordInput.text.toString()

        //TODO registration API
        findNavController().navigate(R.id.action_registration_completed)
    }

}
