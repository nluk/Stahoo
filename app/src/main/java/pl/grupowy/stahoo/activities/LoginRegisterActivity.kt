package pl.grupowy.stahoo.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.fragments.LoginFragment

class LoginRegisterActivity : FragmentActivity(), LoginFragment.SuccessfulLoginListener{
    override fun onSuccesfulLogin(userToken: String) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)

    }

}