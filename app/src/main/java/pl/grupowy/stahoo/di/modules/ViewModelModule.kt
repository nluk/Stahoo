package pl.grupowy.stahoo.di.modules

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import pl.grupowy.stahoo.viewmodel.ViewModelFactory

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}