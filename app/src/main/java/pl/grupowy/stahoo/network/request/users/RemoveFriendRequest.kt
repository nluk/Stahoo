package pl.grupowy.stahoo.network.request.users

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RemoveFriendRequest(
    @Expose
    @SerializedName("friend_id")
    val friendId: Int
)