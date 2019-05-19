package pl.grupowy.stahoo.network.services

import io.reactivex.Observable
import pl.grupowy.stahoo.entities.MainOperation
import retrofit2.http.GET
import retrofit2.http.Path

interface OperationsService {
    @GET("user_operations/{id}")
    fun getUserOperations(@Path("id") id: Int): Observable<List<MainOperation>>
}