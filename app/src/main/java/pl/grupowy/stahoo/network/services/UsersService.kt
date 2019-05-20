package pl.grupowy.stahoo.network.services

import io.reactivex.Completable
import io.reactivex.Single
import pl.grupowy.stahoo.authentication.User
import pl.grupowy.stahoo.network.form.users.LoginForm
import pl.grupowy.stahoo.network.form.users.RegisterForm
import pl.grupowy.stahoo.network.request.users.InvitationRequest
import pl.grupowy.stahoo.network.request.users.RemoveFriendRequest
import pl.grupowy.stahoo.network.request.users.SendInvitationRequest
import pl.grupowy.stahoo.network.request.users.VerifyRequest
import pl.grupowy.stahoo.network.response.users.FriendStatusResponse
import pl.grupowy.stahoo.network.response.users.LoginResponse
import pl.grupowy.stahoo.network.response.users.RegisterResponse
import pl.grupowy.stahoo.network.response.users.UserFriendsResponse
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

    @GET("token/get_user/friends_serialized")
    fun getUserFriends(): Single<UserFriendsResponse>

    @POST("send_invitation/")
    fun sendInvitation(@Body sendInvitationRequest: SendInvitationRequest): Single<FriendStatusResponse>

    @POST("accept_invitation/")
    fun manageInvitation(@Body invitationRequest: InvitationRequest): Single<FriendStatusResponse>

    @POST("remove_friend/")
    fun removeFriend(@Body removeFriendRequest: RemoveFriendRequest): Single<FriendStatusResponse>
}