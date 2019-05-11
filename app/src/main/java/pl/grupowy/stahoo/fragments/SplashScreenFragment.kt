package pl.grupowy.stahoo.fragments

import android.content.Context
import android.os.Bundle
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.application.AppInitializer

class SplashScreenFragment : BaseFragment(), AppInitializer {

    override fun layoutRes(): Int = R.layout.fragment_splashscreen

    override fun initialize() {
    }

    var initCompletedListener: AppInitializer.InitCompletedListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is AppInitializer.InitCompletedListener) {
            initCompletedListener = context
        } else {
            throw RuntimeException("$context must InitCompletedListener")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initialize()
        initCompletedListener?.onInitCompleted()
    }

}
