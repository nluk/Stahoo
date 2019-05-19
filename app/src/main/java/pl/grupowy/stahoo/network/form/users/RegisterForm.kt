package pl.grupowy.stahoo.network.form.users

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterForm(
    @Expose
    val username: String,
    @Expose
    val password: String,
    @Expose
    val email: String,
    @Expose
    @SerializedName("first_name")
    val firstName: String,
    @Expose
    @SerializedName("last_name")
    val lastName: String
)