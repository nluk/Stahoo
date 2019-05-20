package pl.grupowy.stahoo.database.repositories.impl

import pl.grupowy.stahoo.database.dao.OperationDao
import pl.grupowy.stahoo.database.repositories.OperationRepository
import pl.grupowy.stahoo.entities.MainOperation
import java.util.*
import javax.inject.Inject

class OperationRepositoryImpl
@Inject
constructor(private val operationDao: OperationDao) : OperationRepository {
    override fun findById(id: Int): MainOperation = operationDao.findById(id)
    override fun save(e: MainOperation): Long = operationDao.save(e)
    override fun delete(e: MainOperation): Int = operationDao.delete(e)
    override fun deleteAll() = operationDao.deleteAll()
    override fun findAll(): List<MainOperation> = operationDao.findAll()
    override fun findByMonthAndYear(startDate: Date, endDate: Date): List<MainOperation> =
        operationDao.findByMonthAndYear(startDate, endDate)
}