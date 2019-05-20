package pl.grupowy.stahoo.models

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class BasicOperation {
    @Expose
    @PrimaryKey
    var id: Int = 0
    @Expose
    @SerializedName("from_user")
    var costOwnerId: Int = 0
    @Expose
    var amount: Double = 0.0
}