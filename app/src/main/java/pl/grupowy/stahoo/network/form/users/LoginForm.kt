package pl.grupowy.stahoo.network.form.users

import com.google.gson.annotations.Expose

class LoginForm(
    @Expose
    val username: String,
    @Expose
    val password: String
)
