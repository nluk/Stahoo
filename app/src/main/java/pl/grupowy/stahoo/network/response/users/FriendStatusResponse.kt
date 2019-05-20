package pl.grupowy.stahoo.network.response.users

import com.google.gson.annotations.Expose

class FriendStatusResponse(
    @Expose
    val status: String
)