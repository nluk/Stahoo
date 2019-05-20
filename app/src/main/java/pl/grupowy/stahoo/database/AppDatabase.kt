package pl.grupowy.stahoo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.grupowy.stahoo.authentication.Store
import pl.grupowy.stahoo.authentication.User
import pl.grupowy.stahoo.database.dao.OperationDao
import pl.grupowy.stahoo.database.dao.StoreDao
import pl.grupowy.stahoo.database.dao.UserDao
import pl.grupowy.stahoo.entities.MainOperation
import pl.grupowy.stahoo.utils.converters.DateConverter

@Database(entities = [User::class, Store::class, MainOperation::class], version = AppDatabase.VERSION)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun storeDao(): StoreDao
    abstract fun userDao(): UserDao
    abstract fun operationDao(): OperationDao

    companion object {
        const val DATABASE_NAME = "Stahoo"
        const val VERSION = 1
    }
}