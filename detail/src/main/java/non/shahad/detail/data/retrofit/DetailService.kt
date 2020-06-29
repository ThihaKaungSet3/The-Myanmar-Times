package non.shahad.detail.data.retrofit

import non.shahad.detail.data.model.RequestDataModel
import non.shahad.detail.data.response.DetailResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

internal interface DetailService {
    @POST("news/detail")
    suspend fun fetchDetail(
        @Header("Content-Type")gg: String = "application/json",
        @Body req: RequestDataModel
    ) : DetailResponse
}