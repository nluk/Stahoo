package pl.grupowy.stahoo.database.repositories

import androidx.lifecycle.LiveData
import pl.grupowy.stahoo.authentication.User
import pl.grupowy.stahoo.database.repositories.base.Repository

interface UserRepository : Repository<User> {
    fun findById(id: Int): LiveData<User>
}