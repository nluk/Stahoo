package pl.grupowy.stahoo.network.services

import io.reactivex.Completable
import io.reactivex.Single
import pl.grupowy.stahoo.authentication.User
import pl.grupowy.stahoo.network.form.users.LoginForm
import pl.grupowy.stahoo.network.form.users.RegisterForm
import pl.grupowy.stahoo.network.request.users.VerifyRequest
import pl.grupowy.stahoo.network.response.users.LoginResponse
import pl.grupowy.stahoo.network.response.users.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UsersService {
    companion object {
        const val SIGN_IN_ENDPOINT = "token/"
        const val REGISTER_ENDPOINT = "create_user/"
    }

    @POST(SIGN_IN_ENDPOINT)
    fun signIn(@Body loginForm: LoginForm): Single<LoginResponse>

    @POST(REGISTER_ENDPOINT)
    fun register(@Body registerForm: RegisterForm): Single<RegisterResponse>

    @POST("token/verify")
    fun verifyToken(@Body verifyRequest: VerifyRequest): Completable

    @GET("token/get_user")
    fun getUser(): Single<User>
}