package pl.grupowy.stahoo.di.modules.fragmentsbinding

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.grupowy.stahoo.fragments.LoginFragment
import pl.grupowy.stahoo.fragments.RegisterFragment
import pl.grupowy.stahoo.fragments.SplashScreenFragment

@Module
abstract class LoginRegisterActivityFragmentsBindingModule {

    @ContributesAndroidInjector
    internal abstract fun provideLoginFragment(): LoginFragment

    @ContributesAndroidInjector
    internal abstract fun provideRegisterFragment(): RegisterFragment

    @ContributesAndroidInjector
    internal abstract fun provideSplashScreenFragment(): SplashScreenFragment

}