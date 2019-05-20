package pl.grupowy.stahoo.network.request.users

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class InvitationRequest(
    @Expose
    @SerializedName("sender_id")
    val senderId: Int,
    @Expose
    @SerializedName("is_accepted")
    val isAccepted: Boolean
)