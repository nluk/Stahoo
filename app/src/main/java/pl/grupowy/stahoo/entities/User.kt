package pl.grupowy.stahoo.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {
    @Expose
    var id: Int = 0

    @Expose
    var username: String = ""

    @Expose
    var password: String = ""

    @Expose
    var email: String = ""

    @Expose
    @SerializedName("first_name")
    var firstName: String = ""

    @Expose
    @SerializedName("last_name")
    var lastName: String = ""

    var friends: List<User> = emptyList()
}