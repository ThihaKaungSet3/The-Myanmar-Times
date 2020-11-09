package non.shahad.today.data.model

import com.squareup.moshi.Json
import non.shahad.today.data.db.entities.NewsEntity
import non.shahad.today.domain.model.NewsDomainModel

internal data class NewsDataModel(
    @field:Json(name = "_id")
    val id: String,
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "imgUrl")
    val imgUrl : String,
    @field:Json(name = "description")
    val description: String?,
    @field:Json(name = "date_time")
    val dateTime: String?,
    @field:Json(name = "category")
    val categoryName: String
)

internal fun NewsDataModel.toEntity() : NewsEntity {
    return NewsEntity(
        id = this.id,
        title = this.title,
        imgUrl = this.imgUrl,
        description = this.description,
        dateTime = this.dateTime,
        categoryName = this.categoryName,
        lastUpdated = 0L
    )
}

internal fun NewsDataModel.toDomainModel() : NewsDomainModel {
    return NewsDomainModel(
            id = this.id,
            title = this.title,
            imgUrl = this.imgUrl,
            description = this.description,
            dateTime = this.dateTime,
            categoryName = this.categoryName,
            lastUpdated = 0L
    )
}
