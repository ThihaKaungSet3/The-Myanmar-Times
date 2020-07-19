package non.shahad.today.presentation.epoxy.controller

import com.airbnb.epoxy.AutoModel
import com.airbnb.epoxy.Typed3EpoxyController
import com.airbnb.epoxy.Typed4EpoxyController
import com.airbnb.epoxy.paging.PagedListEpoxyController
import non.shahad.today.domain.model.NewsDomainModel
import non.shahad.today.presentation.epoxy.custom.Typed8EpoxyController
import non.shahad.today.presentation.epoxy.model.BannerModel_
import non.shahad.today.presentation.epoxy.model.LatestLabel_
import non.shahad.today.presentation.epoxy.model.LatestNewsModel_
import non.shahad.today.presentation.epoxy.model.RegionalCardModel_

class TodayTypeController(
    private val onItemClick: (String) -> Unit = {}
): Typed8EpoxyController
<NewsDomainModel,List<NewsDomainModel>,List<NewsDomainModel>,List<NewsDomainModel>,
        List<NewsDomainModel>,List<NewsDomainModel>,List<NewsDomainModel>,List<NewsDomainModel>>(){


    override fun buildModels(
        data: NewsDomainModel?,
        data1: List<NewsDomainModel>?,
        data2: List<NewsDomainModel>?,
        data3: List<NewsDomainModel>?,
        data4: List<NewsDomainModel>?,
        data5: List<NewsDomainModel>?,
        data6: List<NewsDomainModel>?,
        data7: List<NewsDomainModel>?
    ) {
        if (data != null){
            BannerModel_()
                .id("BANNER")
                .banner(data)
                .onClick(onItemClick)
                .addTo(this)
        }

        if (data1.isNullOrEmpty().not()){
            LatestLabel_()
                .id("LATEST_LABEL")
                .addTo(this)

            data1?.forEach {
                LatestNewsModel_()
                    .id(it.id)
                    .news(it)
                    .onClick(onItemClick)
                    .addTo(this)
            }
        }

        if (data2.isNullOrEmpty().not()){
            LatestLabel_()
                .id("LATEST_LABEL")
                .addTo(this)

            data2?.forEach {
                LatestNewsModel_()
                    .id(it.id)
                    .news(it)
                    .onClick(onItemClick)
                    .addTo(this)
            }
        }

        if (data3.isNullOrEmpty().not()){
            data3?.forEach {news ->
                RegionalCardModel_()
                    .id(news.id)
                    .news(news)
                    .onClick(onItemClick)
                    .addTo(this)
            }
        }

        if (data4.isNullOrEmpty().not()){
            data4?.forEach {news ->
                RegionalCardModel_()
                    .id(news.id)
                    .news(news)
                    .onClick(onItemClick)
                    .addTo(this)
            }
        }

        if (data5.isNullOrEmpty().not()){
            data5?.forEach {news ->
                RegionalCardModel_()
                    .id(news.id)
                    .news(news)
                    .onClick(onItemClick)
                    .addTo(this)
            }
        }

        if (data6.isNullOrEmpty().not()){
            data6?.forEach {news ->
                RegionalCardModel_()
                    .id(news.id)
                    .news(news)
                    .onClick(onItemClick)
                    .addTo(this)
            }
        }

        if (data7.isNullOrEmpty().not()){
            data7?.forEach {news ->
                RegionalCardModel_()
                    .id(news.id)
                    .news(news)
                    .onClick(onItemClick)
                    .addTo(this)
            }
        }


    }

}
