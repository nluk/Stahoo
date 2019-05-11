package pl.grupowy.stahoo.di.modules

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import pl.grupowy.stahoo.database.AppDatabase
import pl.grupowy.stahoo.database.dao.StoreDao
import pl.grupowy.stahoo.database.dao.UserDao
import pl.grupowy.stahoo.database.repositories.StoreRepository
import pl.grupowy.stahoo.database.repositories.UserRepository
import pl.grupowy.stahoo.database.repositories.impl.StoreRepositoryImpl
import pl.grupowy.stahoo.database.repositories.impl.UserRepositoryImpl
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {

    @Singleton
    @Provides
    fun provideApplication(): Application = app

    @Singleton
    @Provides
    fun provideAppDatabase(app: Application): AppDatabase = Room.databaseBuilder(
        app.applicationContext,
        AppDatabase::class.java, AppDatabase.DATABASE_NAME
    ).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideStoreDao(database: AppDatabase): StoreDao = database.storeDao()

    @Singleton
    @Provides
    fun provideStoreRepository(storeDao: StoreDao): StoreRepository = StoreRepositoryImpl(storeDao)

    @Singleton
    @Provides
    fun provideUserDao(database: AppDatabase): UserDao = database.userDao()

    @Singleton
    @Provides
    fun provideUserRepository(userDao: UserDao): UserRepository = UserRepositoryImpl(userDao)
}