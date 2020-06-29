package non.shahad.detail.data.response

import com.squareup.moshi.Json
import non.shahad.detail.data.model.AuthorDataModel
import non.shahad.detail.data.model.ContentDataModel
import non.shahad.detail.data.model.ImgDataModel
import non.shahad.detail.data.model.toDomainModel
import non.shahad.detail.domain.model.DetailDomainModel

internal data class DetailResponse(
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "author")
    val author: AuthorDataModel,
    @field:Json(name = "date_time")
    val dateTime: String,
    @field:Json(name = "img")
    val img: ImgDataModel,
    @field:Json(name = "summary")
    val summary: String,
    @field:Json(name = "tags")
    val tags: List<String>,
    @field:Json(name = "contents")
    val contents: List<ContentDataModel>
)

internal fun DetailResponse.toDomainModel() =
    DetailDomainModel(
        title = this.title,
        author = this.author.toDomainModel(),
        dateTime = this.dateTime,
        img = this.img.toDomainModel(),
        summary = this.summary,
        tags = this.tags,
        contents = this.contents.map { it.toDomainModel() }
    )