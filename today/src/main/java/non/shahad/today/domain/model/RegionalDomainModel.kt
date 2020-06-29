package non.shahad.today.domain.model

data class RegionalDomainModel (
    val title: String,
    val cards: List<NewsDomainModel>,
    val lists: List<NewsDomainModel>
)