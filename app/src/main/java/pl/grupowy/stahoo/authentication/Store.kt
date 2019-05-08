package pl.grupowy.stahoo.authentication

import androidx.room.*
import pl.grupowy.stahoo.authentication.Store.Companion.TABLE_NAME
import pl.grupowy.stahoo.authentication.enums.StoreMode

@Entity(tableName = TABLE_NAME)
class Store {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var token: String = ""

    @ColumnInfo(name = AUTH_USER_ID)
    @ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = [AUTH_USER_ID],
        onDelete = ForeignKey.CASCADE
    )
    var authUserId: Int = 0

    var mode: String = StoreMode.UNAUTHORIZED.name

    @Ignore
    var authenticatedUser: User? = null

    companion object {
        const val TABLE_NAME = "store"

        const val AUTH_USER_ID = "auth_user_id"
    }
}