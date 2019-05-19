package pl.grupowy.stahoo.fragments

import android.content.Context
import android.os.Bundle
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.application.AppInitializer
import pl.grupowy.stahoo.interfaces.SuccessfulLoginListener

class SplashScreenFragment : BaseFragment(), AppInitializer {

    override fun layoutRes(): Int = R.layout.fragment_splashscreen

    override fun initialize() {
    }

    var initCompletedListener: AppInitializer.InitCompletedListener? = null
    var successfulLoginListener : SuccessfulLoginListener?=null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is AppInitializer.InitCompletedListener) {
            initCompletedListener = context
        } else {
            throw RuntimeException("$context must InitCompletedListener")
        }
        if (context is SuccessfulLoginListener) {
            successfulLoginListener = context
        } else {
            throw RuntimeException("$context must SuccessfulLoginListener")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initialize()
        loginWithStoredData()
        initCompletedListener?.onInitCompleted()
    }

    private fun loginWithStoredData() {
        //TODO("Dodać próbę logowania zapisaną sesją")
        var loginSuccesful = true
        if(loginSuccesful) successfulLoginListener?.onSuccessfulLogin("")
//        findNavController().navigate(R.id.action_login_with_stored_data)
    }

}
