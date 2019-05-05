package pl.grupowy.stahoo.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import kotlinx.android.synthetic.main.activity_login_register.*
import kotlinx.android.synthetic.main.fragment_login_register.*
import kotlinx.android.synthetic.main.fragment_splashscreen.*
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.interfaces.AppInitializer


class SplashScreenFragment : Fragment() , AppInitializer{
    override fun initialize() {

    }

    var inintCompletedListener : AppInitializer.InitCompletedListner? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_splashscreen,container,false)
        return layout
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is AppInitializer.InitCompletedListner) {
            inintCompletedListener = context
        } else {
            throw RuntimeException(context.toString() + " must InitCompletedListener")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initialize()
        inintCompletedListener?.onInitCompleted()
    }





}
