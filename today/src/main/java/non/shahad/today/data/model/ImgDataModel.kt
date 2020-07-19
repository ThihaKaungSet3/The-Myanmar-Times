package non.shahad.today.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import non.shahad.today.domain.model.ImgDomainModel

internal data class ImgDataModel @JvmOverloads constructor(
    @field:Json(name = "default")
    @ColumnInfo(name = "default")
    var default: String? = null,
    @ColumnInfo(name = "sm")
    @field:Json(name = "sm")
    var small: String? = null,
    @field:Json(name = "md")
    @ColumnInfo(name = "md")
    var medium: String? = null,
    @field:Json(name = "lg")
    @ColumnInfo(name = "lg")
    var large: String? = null

)

internal fun ImgDataModel.toDomainModel(): ImgDomainModel {
    return ImgDomainModel(
        small = this.small,
        medium = this.medium,
        large = this.large,
        default = this.default
    )
}