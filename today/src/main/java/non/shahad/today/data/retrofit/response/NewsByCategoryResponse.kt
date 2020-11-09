package non.shahad.today.data.retrofit.response

import com.squareup.moshi.Json
import non.shahad.today.data.model.NewsDataModel

internal data class NewsByCategoryResponse(
    val title: String,
    @field:Json(name = "result")
    val data: List<NewsDataModel>,
    val total: Int,
    val pages: Int
)