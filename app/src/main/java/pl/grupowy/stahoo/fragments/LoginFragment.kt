package pl.grupowy.stahoo.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_login_register.*
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.application.App
import pl.grupowy.stahoo.authentication.Store
import pl.grupowy.stahoo.authentication.User
import pl.grupowy.stahoo.authentication.enums.StoreMode
import pl.grupowy.stahoo.interfaces.SuccessfulLoginListener
import pl.grupowy.stahoo.network.form.users.LoginForm
import pl.grupowy.stahoo.network.response.users.LoginResponse
import pl.grupowy.stahoo.network.services.UsersService
import pl.grupowy.stahoo.utils.TimeUtils
import pl.grupowy.stahoo.viewmodel.LoginViewModel
import pl.grupowy.stahoo.viewmodel.ViewModelFactory
import java.util.*
import javax.inject.Inject

class LoginFragment : BaseFragment() {
    private var listener: SuccessfulLoginListener? = null

    private var viewModelFactory: ViewModelFactory? = null
    private lateinit var loginViewModel: LoginViewModel

    @Inject
    lateinit var usersService: UsersService

    override fun layoutRes(): Int = R.layout.fragment_login_register

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginViewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(LoginViewModel::class.java)

        setListeners()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SuccessfulLoginListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement SuccessfulLoginListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    private fun setListeners() {
        signInButton.setOnClickListener { attemptLogin() }
        registerView.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_to_registration_form,
                null
            )
        )
    }

    private fun clearForm() {
        emailInput.text.clear()
        passwordInput.text.clear()
    }

    private fun attemptLogin() {
        val loginForm = LoginForm(emailInput.text.toString(), passwordInput.text.toString())

        if (loginForm.username.isBlank() || loginForm.password.isBlank()) {
            return
        }

        clearForm()

        doLogin(loginForm)
    }

    @SuppressLint("CheckResult")
    private fun doLogin(loginForm: LoginForm) {
        usersService.signIn(loginForm)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                saveTokenToCheck(result)
                authenticateUser()

                findNavController().navigate(R.id.action_new_login)
            }, { it.printStackTrace() })
    }

    private fun saveTokenToCheck(result: LoginResponse) {
        App.store = Store().apply {
            refreshToken = result.refresh
            refreshTokenExpiredDate = TimeUtils.calculateExpiredTime(Calendar.DAY_OF_YEAR, 1)
            accessToken = result.access
            accessTokenExpiredDate = TimeUtils.calculateExpiredTime(Calendar.MINUTE, 5)
            mode = StoreMode.TOKEN_CHECK.name
        }
    }

    @SuppressLint("CheckResult")
    private fun authenticateUser() {
        usersService.getUser()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ saveUser(it) }, { it.printStackTrace() })
    }

    private fun saveUser(user: User) {
        App.store?.apply {
            authenticatedUser = user
            mode = StoreMode.LOGGED.name
            authUserId = user.id
        }
    }

}
