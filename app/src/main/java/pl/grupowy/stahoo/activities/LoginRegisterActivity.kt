package pl.grupowy.stahoo.activities

import androidx.navigation.findNavController
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.application.AppInitializer
import pl.grupowy.stahoo.interfaces.SuccessfulLoginListener

class LoginRegisterActivity : BaseActivity(), SuccessfulLoginListener,
    AppInitializer.InitCompletedListener {

    override fun layoutRes(): Int = R.layout.activity_login_register

    override fun onInitCompleted() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_to_login)
    }

    override fun onSuccessfulLogin(userToken: String) {
    }
}