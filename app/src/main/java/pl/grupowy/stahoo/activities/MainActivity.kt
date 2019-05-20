package pl.grupowy.stahoo.activities

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import pl.grupowy.stahoo.R

class MainActivity : BaseActivity() {

    override fun layoutRes(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        bottomNav.setupWithNavController(navController)
    }
}
