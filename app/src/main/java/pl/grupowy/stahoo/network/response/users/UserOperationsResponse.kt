package pl.grupowy.stahoo.network.response.users

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class UserOperationsResponse(
    @Expose
    val id: Int,
    @Expose
    @SerializedName("to_user")
    val toUser: Int,
    @Expose
    @SerializedName("from_user")
    val fromUser: Int,
    @Expose
    val amount: Double,
    @Expose
    val name: String,
    @Expose
    val description: String,
    @Expose
    val dateTime: Date,
    @Expose
    val category: Int,
    @Expose
    @SerializedName("cycle_type")
    val cycleType: Int,
    @Expose
    val partials: List<Int>
)