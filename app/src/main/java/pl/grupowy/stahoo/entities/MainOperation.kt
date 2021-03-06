package pl.grupowy.stahoo.entities

import androidx.room.Entity
import androidx.room.Ignore
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import pl.grupowy.stahoo.entities.MainOperation.Companion.TABLE_NAME
import pl.grupowy.stahoo.entities.enums.OperationType
import pl.grupowy.stahoo.models.BasicOperation
import pl.grupowy.stahoo.models.SubOperation
import java.util.*

@Entity(tableName = TABLE_NAME)
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
    @Ignore
    var partials: List<SubOperation> = emptyList()

    @Expose
    @SerializedName("operation_type")
    @Ignore
    var type: OperationType = OperationType.INCOME

    companion object {
        const val TABLE_NAME = "operations"
    }
}