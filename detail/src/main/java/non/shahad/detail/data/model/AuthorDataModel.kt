package non.shahad.detail.data.model

import com.squareup.moshi.Json
import non.shahad.detail.domain.model.AuthorDomainModel

internal data class AuthorDataModel (
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "url")
    val url: String
)

internal fun AuthorDataModel.toDomainModel() =
    AuthorDomainModel(
        name = this.name,
        url = this.url
    )