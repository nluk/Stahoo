package pl.grupowy.stahoo.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import pl.grupowy.stahoo.R



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
        //container?.clearDisappearingChildren()
        //container?.removeAllViews()
        return inflater.inflate(R.layout.fragment_login_register,container,false)
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


}
