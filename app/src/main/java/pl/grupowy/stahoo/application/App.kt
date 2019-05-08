package pl.grupowy.stahoo.application

import android.app.Application
import pl.grupowy.stahoo.authentication.Store

class App : Application() {
    var store: Store? = null

    init {
        instance = this
    }

    companion object {
        lateinit var instance: App
    }

}
