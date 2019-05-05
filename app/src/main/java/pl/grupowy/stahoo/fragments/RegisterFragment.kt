package pl.grupowy.stahoo.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_register_form.*
import pl.grupowy.stahoo.R

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register_form,container,false)
    }

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
        findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
    }


}
