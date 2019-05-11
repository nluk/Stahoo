package pl.grupowy.stahoo.database.repositories.impl

import pl.grupowy.stahoo.authentication.Store
import pl.grupowy.stahoo.database.dao.StoreDao
import pl.grupowy.stahoo.database.repositories.StoreRepository
import javax.inject.Inject


class StoreRepositoryImpl
@Inject
constructor(private val storeDao: StoreDao) : StoreRepository {
    override fun save(e: Store): Long = storeDao.save(e)
    override fun delete(e: Store): Int = storeDao.delete(e)
    override fun deleteAll() = storeDao.clearStore()
}