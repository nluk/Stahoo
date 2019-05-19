package pl.grupowy.stahoo.network.response.users

import com.google.gson.annotations.Expose

class LoginResponse(
    @Expose
    val refresh: String,
    @Expose
    val access: String
)