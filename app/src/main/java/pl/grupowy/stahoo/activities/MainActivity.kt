package pl.grupowy.stahoo.activities

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import pl.grupowy.stahoo.R
import pl.grupowy.stahoo.fragments.LoginFragment

class MainActivity : FragmentActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()

    }

    private fun setupBottomNavigation() {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        bottomNav.setupWithNavController(navController)
    }

}
