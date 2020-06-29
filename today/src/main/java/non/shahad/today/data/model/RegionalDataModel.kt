package non.shahad.today.data.model

import com.squareup.moshi.Json
import non.shahad.today.domain.model.RegionalDomainModel

internal data class RegionalDataModel (
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "cards")
    val cards: List<NewsDataModel>,
    @field:Json(name = "lists")
    val lists: List<NewsDataModel>
)

internal fun RegionalDataModel.toDomainModel() =
    RegionalDomainModel(
        title = this.title,
        cards = this.cards.map { it.toDomainModel() },
        lists = this.lists.map { it.toDomainModel() }
    )
