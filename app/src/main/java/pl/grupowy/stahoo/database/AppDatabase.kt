package pl.grupowy.stahoo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.grupowy.stahoo.authentication.Store
import pl.grupowy.stahoo.authentication.User

@Database(entities = [User::class, Store::class], version = AppDatabase.VERSION)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val VERSION = 1
    }
}