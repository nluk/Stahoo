package pl.grupowy.stahoo.database.repositories

import pl.grupowy.stahoo.database.repositories.base.Repository
import pl.grupowy.stahoo.entities.MainOperation
import java.util.*

interface OperationRepository : Repository<MainOperation> {
    fun findAll(): List<MainOperation>
    fun findById(id: Int): MainOperation
    fun findByMonthAndYear(startDate: Date, endDate: Date): List<MainOperation>
}