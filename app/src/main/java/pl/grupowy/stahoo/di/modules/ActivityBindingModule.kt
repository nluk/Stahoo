package pl.grupowy.stahoo.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.grupowy.stahoo.activities.LoginRegisterActivity
import pl.grupowy.stahoo.activities.MainActivity
import pl.grupowy.stahoo.di.modules.fragmentsbinding.LoginRegisterActivityFragmentsBindingModule
import pl.grupowy.stahoo.di.modules.fragmentsbinding.MainActivityFragmentsBindingModule

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [MainActivityFragmentsBindingModule::class])
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [LoginRegisterActivityFragmentsBindingModule::class])
    internal abstract fun bindLoginRegisterActivity(): LoginRegisterActivity

}