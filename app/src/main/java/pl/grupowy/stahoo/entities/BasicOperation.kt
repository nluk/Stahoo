package pl.grupowy.stahoo.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class BasicOperation {
    @Expose
    var id: Int = 0
    @Expose
    @SerializedName("from_user")
    var costOwnerId: Int = 0
    @Expose
    var amount: Double = 0.0
}