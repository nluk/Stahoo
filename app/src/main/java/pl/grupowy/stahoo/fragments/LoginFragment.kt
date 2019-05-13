package pl.grupowy.stahoo.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login_register.*
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.interfaces.SuccessfulLoginListener


class LoginFragment : BaseFragment() {
    private var listener: SuccessfulLoginListener? = null

    override fun layoutRes(): Int = R.layout.fragment_login_register

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        signInButton.setOnClickListener { signIn() }
        registerView.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_to_registration_form,
                null
            )
        )
    }

    fun signIn() {
        //TODO Add login logic
        findNavController().navigate(R.id.action_new_login)
    }

}
