package pl.grupowy.stahoo.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import pl.grupowy.stahoo.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 *
 */
class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //container?.clearDisappearingChildren()
        //container?.removeAllViews()
        return inflater.inflate(R.layout.fragment_register_form,container,false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            RegisterFragment().apply {}
    }

}
