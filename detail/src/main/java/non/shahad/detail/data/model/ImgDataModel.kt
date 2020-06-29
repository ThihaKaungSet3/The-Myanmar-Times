package non.shahad.detail.data.model

import com.squareup.moshi.Json
import non.shahad.detail.domain.model.ImgDomainModel

internal data class ImgDataModel (
    @field:Json(name = "url")
    val url: String?,
    @field:Json(name = "caption")
    val caption: String?
)

internal fun ImgDataModel.toDomainModel() =
    ImgDomainModel(
        url = this.url,
        caption = this.caption
    )