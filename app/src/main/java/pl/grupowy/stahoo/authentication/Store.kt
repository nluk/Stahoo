package pl.grupowy.stahoo.authentication

import androidx.room.*
import pl.grupowy.stahoo.authentication.Store.Companion.TABLE_NAME
import pl.grupowy.stahoo.authentication.enums.StoreMode
import java.util.*

@Entity(tableName = TABLE_NAME)
class Store {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 1

    @ColumnInfo(name = "refresh_token")
    var refreshToken: String = ""

    @ColumnInfo(name = "refresh_token_expired_date")
    var refreshTokenExpiredDate: Date = Date()

    @ColumnInfo(name = "access_token")
    var accessToken: String = ""

    @ColumnInfo(name = "access_token_expired_date")
    var accessTokenExpiredDate: Date = Date()

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

    override fun toString(): String {
        return "Store(id=$id, refreshToken='$refreshToken', refreshTokenExpiredDate=$refreshTokenExpiredDate, accessToken='$accessToken', accessTokenExpiredDate=$accessTokenExpiredDate, authUserId=$authUserId, mode='$mode', authenticatedUser=$authenticatedUser)"
    }
}