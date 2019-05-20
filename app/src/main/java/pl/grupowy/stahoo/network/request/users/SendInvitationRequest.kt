package pl.grupowy.stahoo.network.request.users

import com.google.gson.annotations.Expose

class SendInvitationRequest(
    @Expose
    val email: String
)