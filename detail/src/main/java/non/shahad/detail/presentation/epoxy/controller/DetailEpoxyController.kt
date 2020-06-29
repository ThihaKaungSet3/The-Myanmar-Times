package non.shahad.detail.presentation.epoxy.controller

import com.airbnb.epoxy.EpoxyController
import non.shahad.detail.domain.model.DetailDomainModel
import non.shahad.detail.presentation.epoxy.models.*

class DetailEpoxyController : EpoxyController() {

    private var detail: DetailDomainModel? = null

    override fun buildModels() {
        if (detail != null){
            TitleModel_()
                .id("TITLE")
                .title(detail?.title!!)
                .addTo(this)

            if (detail?.img != null){
                DetailBannerModel_()
                    .id("BANNER")
                    .img(detail?.img!!)
                    .addTo(this)
            }

            HeaderModel_()
                .id("HEADER")
                .header(Pair(detail?.author?.name!!,detail?.dateTime!!))
                .addTo(this)

            SummaryModel_()
                .id("SUMMARY")
                .summary(detail?.summary!!)
                .addTo(this)

            if (detail?.contents.isNullOrEmpty().not()){
                detail?.contents?.forEach {content ->
                    ContentModel_()
                        .id("CONTENT")
                        .content(content.paragraph)
                        .addTo(this)
                }
            }
        }


    }

    fun mutate(detail: DetailDomainModel){
        this.detail = detail
        requestModelBuild()
    }
}