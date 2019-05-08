package pl.grupowy.stahoo.database.dao

import androidx.room.Query
import pl.grupowy.stahoo.authentication.User
import pl.grupowy.stahoo.database.Dao


interface UserDao : Dao<User> {
    @Query("DELETE FROM " + User.TABLE_NAME)
    fun deleteAll()
}