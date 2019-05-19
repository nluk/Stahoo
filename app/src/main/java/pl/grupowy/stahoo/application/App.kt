package pl.grupowy.stahoo.application

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import pl.grupowy.stahoo.authentication.Store
import pl.grupowy.stahoo.di.component.AppComponent
import pl.grupowy.stahoo.di.component.DaggerAppComponent

import pl.grupowy.stahoo.di.modules.AppModule
import pl.grupowy.stahoo.di.modules.NetworkModule

class App : DaggerApplication() {
    companion object {
        var store: Store? = null
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val component: AppComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule)
            .build()

        component.inject(this)

        return component
    }
}
