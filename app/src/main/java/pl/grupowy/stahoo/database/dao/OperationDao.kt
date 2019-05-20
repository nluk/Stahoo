package pl.grupowy.stahoo.database.dao

import androidx.room.Dao
import androidx.room.Query
import pl.grupowy.stahoo.entities.MainOperation
import java.util.*

@Dao
interface OperationDao : BaseDao<MainOperation> {
    @Query("SELECT * FROM ${MainOperation.TABLE_NAME}")
    fun findAll(): List<MainOperation>

    @Query("SELECT * FROM ${MainOperation.TABLE_NAME} WHERE id = :id")
    fun findById(id: Int): MainOperation

    @Query(
        "SELECT * FROM ${MainOperation.TABLE_NAME} " +
                "WHERE date(datetime) >= date(:startDate) AND date(datetime) < date(:endDate)"
    )
    fun findByMonthAndYear(startDate: Date, endDate: Date): List<MainOperation>

    @Query("DELETE FROM ${MainOperation.TABLE_NAME}")
    fun deleteAll()
}