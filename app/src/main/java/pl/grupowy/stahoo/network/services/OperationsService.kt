package pl.grupowy.stahoo.network.services

import io.reactivex.Single
import pl.grupowy.stahoo.network.response.users.UserOperationsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface OperationsService {
    @GET("user_operations/{id}")
    fun getUserOperations(@Path("id") id: Int): Single<List<UserOperationsResponse>>

//    @POST("operations/")
//    fun createOperation(): Single<OperationResponse>
//
//    @PUT("operations/{id}/")
//    fun updateOperation(@Path("id") id: Int): Single<OperationResponse>
}