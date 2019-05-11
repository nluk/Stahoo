package pl.grupowy.stahoo.database.repositories.base

interface Repository<E> {
    fun save(e: E): Long
    fun delete(e: E): Int
    fun deleteAll()
}