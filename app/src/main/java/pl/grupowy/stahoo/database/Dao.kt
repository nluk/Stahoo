package pl.grupowy.stahoo.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update


interface Dao<T> {
    @Insert
    fun insert(t: T)

    @Update
    fun update(t: T)

    @Delete
    fun delete(t: T)
}