package pl.grupowy.stahoo.di.modules.fragmentsbinding

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.grupowy.stahoo.fragments.FriendsListFragment
import pl.grupowy.stahoo.fragments.OperationHandlerFragment
import pl.grupowy.stahoo.fragments.OperationsListFragment
import pl.grupowy.stahoo.fragments.StatisticsFragment

@Module
abstract class MainActivityFragmentsBindingModule {

    @ContributesAndroidInjector
    internal abstract fun provideFriendsListFragment(): FriendsListFragment

    @ContributesAndroidInjector
    internal abstract fun provideOperationHandlerFragment(): OperationHandlerFragment

    @ContributesAndroidInjector
    internal abstract fun provideOperationsListFragment(): OperationsListFragment

    @ContributesAndroidInjector
    internal abstract fun provideStatisticsFragment(): StatisticsFragment

}