package pl.grupowy.stahoo.database.dao

import androidx.room.Query
import pl.grupowy.stahoo.authentication.Store
import pl.grupowy.stahoo.database.Dao


interface StoreDao : Dao<Store> {
    @Query("DELETE FROM " + Store.TABLE_NAME)
    fun clearStore()
}