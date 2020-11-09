package non.shahad.today.data.db.entities

import androidx.room.*
import non.shahad.today.domain.model.NewsDomainModel

@Entity(tableName = "today_news")
internal data class NewsEntity @JvmOverloads constructor(
    @PrimaryKey
    @ColumnInfo(name = "_id")
    val id: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "img_url")
    val imgUrl : String,
    @ColumnInfo(name = "description")
    val description: String?,
    @ColumnInfo(name = "date_time")
    val dateTime: String?,
    @ColumnInfo(name = "page")
    var page: Int = -1,
    @ColumnInfo(name = "category")
    var categoryName: String = "",
    @ColumnInfo(name = "last_updated")
    var lastUpdated: Long
){

}

internal fun NewsEntity.toDomainModel() : NewsDomainModel {
    return NewsDomainModel(
        id = this.id,
        title = this.title,
        categoryName = this.categoryName,
        imgUrl = this.imgUrl,
        description = this.description,
        dateTime = this.dateTime,
        lastUpdated = this.lastUpdated
    )
}

internal fun NewsDomainModel.toEntity() : NewsEntity {
    return NewsEntity(
            id = this.id,
            title = this.title,
            imgUrl = this.imgUrl,
            description = this.description,
            dateTime = this.dateTime,
            categoryName = this.categoryName,
            lastUpdated = this.lastUpdated
    )
}