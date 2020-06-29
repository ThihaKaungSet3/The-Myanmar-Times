package non.shahad.today.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import non.shahad.today.data.model.ImgDataModel
import non.shahad.today.data.model.NewsDataModel
import non.shahad.today.data.model.toDomainModel
import non.shahad.today.domain.model.NewsDomainModel

@Entity(tableName = "today_news")
internal data class NewsEntity (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "link")
    val link: String,
    @ColumnInfo(name = "img_url")
    val imgUrls : ImgDataModel?,
    @ColumnInfo(name = "description")
    val description: String?,
    @ColumnInfo(name = "date_time")
    val dateTime: String?,
    @ColumnInfo(name = "tags")
    val tags: List<String>?,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "page")
    var page: Int = -1,
    @ColumnInfo(name = "category_name")
    var categoryName: String = ""
)

internal fun NewsEntity.toDomainModel() : NewsDomainModel {
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