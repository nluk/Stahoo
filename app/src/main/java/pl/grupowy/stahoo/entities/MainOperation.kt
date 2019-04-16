package pl.grupowy.stahoo.entities

import android.arch.persistence.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import pl.grupowy.stahoo.entities.enums.OperationType
import java.util.*

@Entity(primaryKeys = ["id"])
class MainOperation : BasicOperation() {
    @Expose
    @SerializedName("target_user")
    var debtUserId: Int = 0

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
    var category: Int = 0

    @Expose
    var partials: List<SubOperation> = emptyList()

    @Expose
    @SerializedName("operation_type")
    var type: OperationType = OperationType.INCOME
}