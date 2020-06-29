package non.shahad.detail.data.model

import com.squareup.moshi.Json
import non.shahad.detail.domain.model.ContentDomainModel

internal data class ContentDataModel(
    @field:Json(name = "paragraph")
    val paragraph: String
)

internal fun ContentDataModel.toDomainModel() =
    ContentDomainModel(
        paragraph = this.paragraph
    )