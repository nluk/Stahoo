package pl.grupowy.stahoo.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface BaseDao<E> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(e: E): Long

    @Delete
    fun delete(e: E): Int
}