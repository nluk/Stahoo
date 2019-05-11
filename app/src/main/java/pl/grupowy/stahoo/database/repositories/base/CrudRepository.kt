package pl.grupowy.stahoo.database.repositories.base

import androidx.lifecycle.LiveData

interface CrudRepository<E> : Repository<E> {
    fun saveAll(e: Iterable<E>): Iterable<E>
    fun findById(id: Int): LiveData<E>
    fun existsById(id: Int): Boolean
    fun findAll(): LiveData<Iterable<E>>
    fun count(): Int
}