package pl.grupowy.stahoo.database.repositories.impl

import androidx.lifecycle.LiveData
import pl.grupowy.stahoo.authentication.User
import pl.grupowy.stahoo.database.dao.UserDao
import pl.grupowy.stahoo.database.repositories.UserRepository
import javax.inject.Inject

class UserRepositoryImpl
@Inject
constructor(private val userDao: UserDao) : UserRepository {
    override fun findById(id: Int): LiveData<User> = userDao.findById(id)
    override fun save(e: User): Long = userDao.save(e)
    override fun delete(e: User): Int = userDao.delete(e)
    override fun deleteAll() = userDao.deleteAll()
}