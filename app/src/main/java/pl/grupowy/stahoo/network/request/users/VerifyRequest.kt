package pl.grupowy.stahoo.network.request.users

import com.google.gson.annotations.Expose

class VerifyRequest(
    @Expose
    val token: String
)