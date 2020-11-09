package non.shahad.today.data.retrofit.response

import com.squareup.moshi.Json
import non.shahad.today.data.model.NewsDataModel

internal data class HeadlineResponse(
    @field:Json(name = "headline")
    val headlines: List<NewsDataModel>
)