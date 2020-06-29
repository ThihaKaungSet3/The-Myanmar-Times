package non.shahad.today.domain.model

data class NewsDomainModel(
    val id: String,
    val title: String,
    val link: String,
    val imgUrls : ImgDomainModel?,
    val description: String?,
    val dateTime: String?,
    val tags: List<String>?,
    val type: String
)