package pl.grupowy.stahoo.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_register_form.*
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.authentication.User

class RegisterFragment : BaseFragment() {

    override fun layoutRes(): Int = R.layout.fragment_register_form

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        registerButton.setOnClickListener { attemptRegistration() }
        back_to_login.setOnClickListener{findNavController().navigate(R.id.action_registration_completed)}
    }

    private fun attemptRegistration() {
        val nickname = nicknameInput.text.toString()
        val email = emailInput.text.toString()
        val password = passwordInput.text.toString()
        val firstName = firstnameInput.text.toString()
        val lastName = lastnameInput.text.toString()

        val newUser = User()
        newUser.username = nickname
        newUser.email = email
        newUser.firstName = firstName
        newUser.lastName = lastName
        newUser.password = password

        //TODO("registration API")
        //registerUser(newUser)

        findNavController().navigate(R.id.action_registration_completed)
    }

}
