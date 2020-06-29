package non.shahad.today.presentation.epoxy.controller

import com.airbnb.epoxy.EpoxyController
import non.shahad.today.domain.model.NewsDomainModel
import non.shahad.today.domain.types.RegionalNews
import non.shahad.today.presentation.epoxy.model.*

class TodayController (
    private val onItemClick: (String) -> Unit = {}
): EpoxyController(){
    private var banner: NewsDomainModel? = null
    private val latestNews = mutableListOf<NewsDomainModel>()
    private var shouldShowLatestLabel: Boolean = false

    private val newsByCategory = mutableListOf<Pair<Int,List<NewsDomainModel>>>()

    override fun buildModels() {

        if (banner != null){
            BannerModel_()
                .id("BANNER")
                .banner(banner!!)
                .onClick(onItemClick)
                .addTo(this)
        }

        LatestLabel_()
            .id("LATEST_LABEL")
            .addIf(shouldShowLatestLabel,this)

        if (latestNews.isNullOrEmpty().not()){
            latestNews.forEach {
                LatestNewsModel_()
                    .id(it.id)
                    .news(it)
                    .onClick(onItemClick)
                    .addTo(this)
            }
        }

        if (newsByCategory.isNullOrEmpty().not()){
            newsByCategory.forEach {
                it.second.forEach { news ->
                    RegionalCardModel_()
                        .id(news.id)
                        .news(news)
                        .onClick(onItemClick)
                        .addTo(this)
                }
            }
        }

//        if (regionalNews.isNullOrEmpty().not()){
//
//            regionalNews.forEach {
//
//                RegionalLabelModel_()
//                    .id(it.hashCode())
//                    .title(it.first)
//                    .addTo(this)
//
//                it.second.forEach { news ->
//                    RegionalCardModel_()
//                        .id(news.id)
//                        .news(news)
//                        .onClick(onItemClick)
//                        .addTo(this)
//                }
//
//                if (it.second.isNullOrEmpty().not()) {
//                    it.second.forEach { news ->
//                        RegionalListModel_()
//                            .id(news.id)
//                            .news_(news)
//                            .onClick(onItemClick)
//                            .addTo(this)
//                    }
//
//                }
//            }
//        }

    }

    fun addBanner(banner: NewsDomainModel) {
        this.banner = banner
        requestModelBuild()
    }

    fun addLatestNews(latestNews_: List<NewsDomainModel>){
        shouldShowLatestLabel = true
        with(this.latestNews){
            clear()
            addAll(latestNews_)
        }
        requestModelBuild()
    }

    fun addNewsByCategory(news: Pair<Int,List<NewsDomainModel>>){
        with(this.newsByCategory){
            addAll(listOf(news))
        }
        requestModelBuild()
    }

}