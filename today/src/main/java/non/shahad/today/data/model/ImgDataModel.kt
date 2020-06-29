package non.shahad.today.data.model

import com.squareup.moshi.Json
import non.shahad.today.domain.model.ImgDomainModel

internal data class ImgDataModel (
    @field:Json(name = "sm")
    val small: String?,
    @field:Json(name = "md")
    val medium: String?,
    @field:Json(name = "lg")
    val large: String?,
    @field:Json(name = "default")
    val default: String
)

internal fun ImgDataModel.toDomainModel(): ImgDomainModel {
    return ImgDomainModel(
        small = this.small,
        medium = this.medium,
        large = this.large,
        default = this.default
    )
}