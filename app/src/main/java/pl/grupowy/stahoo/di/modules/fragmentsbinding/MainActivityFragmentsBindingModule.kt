package pl.grupowy.stahoo.di.modules.fragmentsbinding

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.grupowy.stahoo.fragments.*

@Module
abstract class MainActivityFragmentsBindingModule {

    @ContributesAndroidInjector
    internal abstract fun provideFriendsListFragment(): FriendsListFragment

    @ContributesAndroidInjector
    internal abstract fun provideAddEditOperationFragment(): AddEditOperationFragment

    @ContributesAndroidInjector
    internal abstract fun provideViewOperationFragment(): ViewOperationFragment

    @ContributesAndroidInjector
    internal abstract fun provideOperationsListFragment(): OperationsListFragment

    @ContributesAndroidInjector
    internal abstract fun provideStatisticsFragment(): StatisticsFragment

}