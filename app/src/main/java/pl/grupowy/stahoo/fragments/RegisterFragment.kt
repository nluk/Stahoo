package pl.grupowy.stahoo.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_register_form.*
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.network.form.users.RegisterForm
import pl.grupowy.stahoo.network.services.UsersService
import javax.inject.Inject

class RegisterFragment : BaseFragment() {

    @Inject
    lateinit var usersService: UsersService

    override fun layoutRes(): Int = R.layout.fragment_register_form

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        registerButton.setOnClickListener { attemptRegistration() }
        back_to_login.setOnClickListener { findNavController().navigate(R.id.action_registration_completed) }
    }

    private fun clearForm() {
        nicknameInput.text.clear()
        passwordInput.text.clear()
        emailInput.text.clear()
        firstnameInput.text.clear()
        lastnameInput.text.clear()
    }

    private fun attemptRegistration() {

        val registerForm = RegisterForm(
            nicknameInput.text.toString(), passwordInput.text.toString(),
            emailInput.text.toString(), firstnameInput.text.toString(), lastnameInput.text.toString()
        )

        if (registerForm.username.isBlank() || registerForm.password.isBlank() || registerForm.email.isBlank()) {
            return
        }

        clearForm()

        registerUser(registerForm)
    }

    @SuppressLint("CheckResult")
    private fun registerUser(registerForm: RegisterForm) {
        usersService.register(registerForm)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ findNavController().navigate(R.id.action_registration_completed) },
                { it.printStackTrace() })
    }

}
