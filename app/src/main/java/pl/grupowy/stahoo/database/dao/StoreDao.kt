package pl.grupowy.stahoo.database.dao

import androidx.room.Dao
import androidx.room.Query
import pl.grupowy.stahoo.authentication.Store

@Dao
interface StoreDao : BaseDao<Store> {
    @Query("DELETE FROM ${Store.TABLE_NAME}")
    fun clearStore()
}