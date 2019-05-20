package pl.grupowy.stahoo.network.response.users

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserFriendsResponse(
    @Expose
    val id: Int,
    @Expose
    val username: String,
    @Expose
    val email: String,
    @Expose
    @SerializedName("first_name")
    val firstName: String,
    @Expose
    @SerializedName("last_name")
    val lastName: String,
    @Expose
    val friends: List<UserResponse>,
    @Expose
    val pending: List<UserResponse>
)