package non.shahad.today.data.model

import com.squareup.moshi.Json

data class News(
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "link")
    val link: String,
    @field:Json(name = "img_url")
    val imgUrls : Img?,
    @field:Json(name = "description")
    val description: String?,
    @field:Json(name = "date_time")
    val dateTime: String?,
    @field:Json(name = "tags")
    val tags: List<String>,
    @field:Json(name = "type")
    val type: String
)