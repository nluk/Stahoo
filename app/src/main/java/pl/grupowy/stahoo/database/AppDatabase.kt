package pl.grupowy.stahoo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.grupowy.stahoo.authentication.Store
import pl.grupowy.stahoo.authentication.User
import pl.grupowy.stahoo.database.dao.StoreDao
import pl.grupowy.stahoo.database.dao.UserDao

@Database(entities = [User::class, Store::class], version = AppDatabase.VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract fun storeDao(): StoreDao
    abstract fun userDao(): UserDao

    companion object {
        const val DATABASE_NAME = "Stahoo"
        const val VERSION = 1
    }
}