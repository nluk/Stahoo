package pl.grupowy.stahoo.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import pl.grupowy.stahoo.authentication.User

@Dao
interface UserDao : BaseDao<User> {
    @Query("SELECT * FROM ${User.TABLE_NAME} WHERE id = :id")
    fun findById(id: Int): LiveData<User>

    @Query("DELETE FROM ${User.TABLE_NAME}")
    fun deleteAll()
}