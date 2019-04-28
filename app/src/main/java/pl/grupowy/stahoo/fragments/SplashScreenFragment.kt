package pl.grupowy.stahoo.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.NavHostFragment.findNavController
import kotlinx.android.synthetic.main.activity_login_register.*
import kotlinx.android.synthetic.main.fragment_splashscreen.*
import pl.grupowy.stahoo.R



class SplashScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        container?.clearDisappearingChildren()
        container?.removeAllViews()
        return inflater.inflate(R.layout.fragment_splashscreen,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val navController = findNavController(nav_host_fragment)
        textView.setOnClickListener{
            findNavController(nav_host_fragment).navigate(R.id.action_splashScreenFragment_to_loginFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SplashScreenFragment().apply {}
    }


}
