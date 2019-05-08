package pl.grupowy.stahoo.authentication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import pl.grupowy.stahoo.authentication.Store.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
class User {
    @Expose
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @Expose
    var username: String = ""

    @Expose
    var password: String = ""

    @Expose
    var email: String = ""

    @Expose
    @SerializedName(FIRST_NAME)
    @ColumnInfo(name = FIRST_NAME)
    var firstName: String = ""

    @Expose
    @SerializedName(LAST_NAME)
    @ColumnInfo(name = LAST_NAME)
    var lastName: String = ""

    @Ignore
    var friends: List<User> = emptyList()

    companion object {
        const val TABLE_NAME = "users"

        const val FIRST_NAME = "first_name"
        const val LAST_NAME = "last_name"
    }
}