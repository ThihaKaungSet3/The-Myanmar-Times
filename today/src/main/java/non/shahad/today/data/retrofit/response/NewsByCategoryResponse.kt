package non.shahad.today.data.retrofit.response

import com.squareup.moshi.Json
import non.shahad.today.data.model.NewsDataModel

internal data class NewsByCategoryResponse(
    val title: String,
    @field:Json(name = "data")
    val data: List<NewsDataModel>
)