package pl.grupowy.stahoo.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.fragments.LoginFragment
import pl.grupowy.stahoo.interfaces.AppInitializer

class LoginRegisterActivity : FragmentActivity(), LoginFragment.SuccessfulLoginListener, AppInitializer.InitCompletedListner{
    override fun onInitCompleted() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_splashScreenFragment_to_loginFragment)
    }

    override fun onSuccesfulLogin(userToken: String) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)

    }

}