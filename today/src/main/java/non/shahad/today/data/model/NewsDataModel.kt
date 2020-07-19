package non.shahad.today.data.model

import com.squareup.moshi.Json
import non.shahad.today.data.db.entities.NewsEntity
import non.shahad.today.domain.model.NewsDomainModel

internal data class NewsDataModel(
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "link")
    val link: String,
    @field:Json(name = "img_url")
    val imgUrls : ImgDataModel?,
    @field:Json(name = "description")
    val description: String?,
    @field:Json(name = "date_time")
    val dateTime: String?,
    @field:Json(name = "tags")
    val tags: List<String>?,
    @field:Json(name = "type")
    val type: String
)

internal fun NewsDataModel.toEntity() : NewsEntity {
    return NewsEntity(
        id = this.id,
        title = this.title,
        link = this.link,
        imgUrls = imgUrls,
        description = this.description,
        dateTime = this.dateTime,
        tags = this.tags,
        type = this.type
    )
}

internal fun NewsDataModel.toDomainModel() : NewsDomainModel {
    return NewsDomainModel(
        id = this.id,
        title = this.title,
        link = this.link,
        imgUrls = this.imgUrls?.toDomainModel(),
        description = this.description,
        dateTime = this.dateTime,
        tags = this.tags,
        type = this.type
    )
}
