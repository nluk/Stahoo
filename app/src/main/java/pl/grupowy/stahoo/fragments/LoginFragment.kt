package pl.grupowy.stahoo.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login_register.*
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.application.App


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [LoginFragment.SuccessfulLoginListener] interface
 * to handle interaction events.
 *
 */
class LoginFragment : Fragment() {
    private var listener: SuccessfulLoginListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.fragment_login_register,container,false)

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SuccessfulLoginListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement SuccessfulLoginListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface SuccessfulLoginListener {
        fun onSuccesfulLogin(userToken: String)
    }

    fun setListeners(){
        signInButton.setOnClickListener {signIn()}
        registerView.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_registerFragment,null))
    }

    fun signIn(){
        //TODO Add login logic
        findNavController().navigate(R.id.action_loginFragment_to_mainActivity)
    }


}
