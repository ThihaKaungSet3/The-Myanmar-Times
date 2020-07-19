package non.shahad.today.presentation.epoxy.controller

import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.OnModelBuildFinishedListener
import non.shahad.core.extensions.timber
import non.shahad.today.domain.model.NewsDomainModel
import non.shahad.today.domain.types.RegionalNews
import non.shahad.today.presentation.epoxy.model.*
import java.util.HashSet

class TodayController(
        private val onItemClick: (String) -> Unit = {}
) : EpoxyController() {
    private var banner: NewsDomainModel? = null
    private var latestNews = mutableListOf<NewsDomainModel>()
    private var shouldShowLatestLabel: Boolean = false

    private var newsByCategory = mutableListOf<Pair<Int,List<NewsDomainModel>>>()
    // Should be dynamic (bad practice)
    private var covidNews = mutableListOf<NewsDomainModel>()
    private var nationalNews = mutableListOf<NewsDomainModel>()
    private var businessNews = mutableListOf<NewsDomainModel>()
    private var worldNews = mutableListOf<NewsDomainModel>()
    private var lifeStyleNews = mutableListOf<NewsDomainModel>()
    private var sportsNews = mutableListOf<NewsDomainModel>()

    override fun buildModels() {

        if (banner != null) {
            BannerModel_()
                    .id("BANNER")
                    .banner(banner!!)
                    .onClick(onItemClick)
                    .addTo(this)
        }

        LatestLabel_()
                .id("LATEST_LABEL")
                .addIf(shouldShowLatestLabel, this)

        if (latestNews.isNullOrEmpty().not()) {
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

//        if (covidNews.isNullOrEmpty().not()) {
//            covidNews.forEach {news ->
//                RegionalCardModel_()
//                    .id(news.id)
//                    .news(news)
//                    .onClick(onItemClick)
//                    .addTo(this)
//            }
//        }
//
//        if (nationalNews.isNullOrEmpty().not()) {
//            nationalNews.forEach {news ->
//                RegionalCardModel_()
//                    .id(news.id)
//                    .news(news)
//                    .onClick(onItemClick)
//                    .addTo(this)
//            }
//        }
//
//        if (worldNews.isNullOrEmpty().not()) {
//            worldNews.forEach {news ->
//                RegionalCardModel_()
//                    .id(news.id)
//                    .news(news)
//                    .onClick(onItemClick)
//                    .addTo(this)
//            }
//        }
//
//        if (businessNews.isNullOrEmpty().not()) {
//            businessNews.forEach {news ->
//                RegionalCardModel_()
//                    .id(news.id)
//                    .news(news)
//                    .onClick(onItemClick)
//                    .addTo(this)
//            }
//        }
//
//        if (sportsNews.isNullOrEmpty().not()) {
//            sportsNews.forEach {news ->
//                RegionalCardModel_()
//                    .id(news.id)
//                    .news(news)
//                    .onClick(onItemClick)
//                    .addTo(this)
//            }
//        }
//
//        if (lifeStyleNews.isNullOrEmpty().not()) {
//            lifeStyleNews.forEach {news ->
//                RegionalCardModel_()
//                    .id(news.id)
//                    .news(news)
//                    .onClick(onItemClick)
//                    .addTo(this)
//            }
//        }



    }

    fun addBanner(banner: NewsDomainModel) {
        this.banner = banner
        requestModelBuild()
    }

    fun addLatestNews(latestNews_: List<NewsDomainModel>) {
        shouldShowLatestLabel = true
        if (latestNews_.isNullOrEmpty().not()) {
            this.latestNews = latestNews_.toMutableList()
            requestModelBuild()
        }
    }

    fun addNewsByCategory(newsPair: Pair<Int,List<NewsDomainModel>>){
        val currentList = newsByCategory

        val duplicatePosition = findPositionOfDuplicate(currentList,newsPair.first)

        if (duplicatePosition != -1){
            timber("Controller!!","Duplicated ${newsPair.first}")
            currentList[duplicatePosition] = newsPair
        }else {
            timber("Controller!!","${newsPair.first}")
//            currentList.addAll(listOf(newsPair))
        }

        this.newsByCategory = currentList
        requestModelBuild()
    }

    private fun findPositionOfDuplicate(lists: List<Pair<Int, List<NewsDomainModel>>>,key: Int): Int{
        lists.forEachIndexed { index, pair ->
            timber("Controller!!","Current ${pair.first} and $key")
            if (pair.first == key) return index
        }
        return -1
    }

    /**
     * Should be dynamic
     */
    fun addCovidNews(news: List<NewsDomainModel>){
        this.covidNews = news.toMutableList()
        requestModelBuild()
    }

    fun addNationalNews(news: List<NewsDomainModel>){
        this.nationalNews = news.toMutableList()
        requestModelBuild()
    }

    fun addWorldNews(news: List<NewsDomainModel>){
        this.worldNews = news.toMutableList()
        requestModelBuild()
    }

    fun addBusinessNews(news: List<NewsDomainModel>){
        this.businessNews = news.toMutableList()
        requestModelBuild()
    }

    fun addSportNews(news: List<NewsDomainModel>){
        this.sportsNews = news.toMutableList()
        requestModelBuild()
    }

    fun addLifeStyleNews(news: List<NewsDomainModel>){
        this.lifeStyleNews = news.toMutableList()
        requestModelBuild()
    }




}