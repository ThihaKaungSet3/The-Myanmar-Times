package non.shahad.detail.data.model

import com.squareup.moshi.Json

data class RequestDataModel (
    @field:Json(name = "url")
    val url: String
)