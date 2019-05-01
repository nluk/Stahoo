package pl.grupowy.stahoo.activities

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.fragments.LoginFragment

class LoginRegisterActivity : FragmentActivity(), LoginFragment.SuccessfulLoginListener{
    override fun onSuccesfulLogin(userToken: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)
        //val host = NavHostFragment.create(R.navigation.navigation_register_login)
        //supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment,host).setPrimaryNavigationFragment(host).commit()
    }

}