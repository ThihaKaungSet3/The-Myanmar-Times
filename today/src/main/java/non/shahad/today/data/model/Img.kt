package non.shahad.today.data.model

import com.squareup.moshi.Json

data class Img (
    @field:Json(name = "sm")
    val small: String,
    @field:Json(name = "md")
    val medium: String,
    @field:Json(name = "lg")
    val large: String
)