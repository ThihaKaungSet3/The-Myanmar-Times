package non.shahad.detail.domain.model

import non.shahad.detail.data.model.ImgDataModel


data class DetailDomainModel(
    val title: String,
    val author: AuthorDomainModel,
    val dateTime: String,
    val img: ImgDomainModel,
    val summary: String,
    val tags: List<String>,
    val contents: List<ContentDomainModel>
)