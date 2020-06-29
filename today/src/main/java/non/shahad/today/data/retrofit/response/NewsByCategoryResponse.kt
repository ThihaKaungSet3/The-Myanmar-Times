package non.shahad.today.data.retrofit.response

import non.shahad.today.data.model.NewsDataModel

internal data class NewsByCategoryResponse(
    val title: String,
    val posts: List<NewsDataModel>
)