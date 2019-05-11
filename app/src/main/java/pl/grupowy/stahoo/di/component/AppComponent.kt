package pl.grupowy.stahoo.di.component

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import pl.grupowy.stahoo.application.App
import pl.grupowy.stahoo.di.modules.ActivityBindingModule
import pl.grupowy.stahoo.di.modules.AppModule
import pl.grupowy.stahoo.di.modules.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, ActivityBindingModule::class,
        NetworkModule::class, AndroidSupportInjectionModule::class]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(application: App)

    @Component.Builder
    interface Builder {
        fun appModule(appModule: AppModule): Builder
        fun networkModule(networkModule: NetworkModule): Builder

        fun build(): AppComponent
    }
}