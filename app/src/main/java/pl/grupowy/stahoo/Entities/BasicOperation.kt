package pl.grupowy.stahoo.Entities


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

//

open class BasicOperation{

    @Expose
    var id:Int = 0

    @Expose
    @SerializedName("from_user")
    var costOwnerId:Int = 0

    @Expose
    var amount: Double = 0.0




}