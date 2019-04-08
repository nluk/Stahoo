package pl.grupowy.stahoo.Entities

import android.arch.persistence.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(primaryKeys = arrayOf("id"))
class MainOperation : BasicOperation(){


    @Expose
    @SerializedName("target_user")
    var debtUserId:Int = 0

    @Expose
    @SerializedName("name")
    var name: String = ""

    @Expose
    @SerializedName("description")
    var description: String = ""

    @Expose
    @SerializedName("cycle")
    var isCyclical: Boolean = false

    @Expose
    @SerializedName("")
    var isDivided: Boolean = false

    @Expose
    @SerializedName("datetime")
    var dateTime: Date = Date()

    @Expose
    var category:Int = 0

    @Expose
    var partials:List<SubOperation> = emptyList()

    @Expose
    @SerializedName("operation_tpe")
    var type:OperationType = OperationType.INCOME
}