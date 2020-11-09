package non.shahad.today.data.usecase

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import non.shahad.today.data.db.daos.TodayNewsDao
import non.shahad.today.data.db.entities.toDomainModel
import non.shahad.today.data.db.entities.toEntity
import non.shahad.today.data.model.toDomainModel
import non.shahad.today.data.retrofit.service.TodayService
import non.shahad.today.domain.model.NewsDomainModel
import timber.log.Timber
import javax.inject.Inject

internal class TodayUseCase @Inject constructor(
        private val service: TodayService,
        private val dao: TodayNewsDao
) {

    fun streamedHeadline(): Single<List<NewsDomainModel>> {
        return Observable.merge(
                dao.getNewsByCategoryAndPage(1,"headlines").map { entity ->
                    entity.map { it.toDomainModel() }
                }.filter{
                    Timber.d("Hits $it")
                    return@filter true
                }.subscribeOn(Schedulers.io()),

                service.fetchHeadlinesNews().map {
                    Timber.d("Fresh: $it")
                    it.headlines.map { data ->  data.toDomainModel() }
                }
                .doOnNext {
                    dao.insertMappedNews(1,"headlines",it.map { domain ->  domain.toEntity() })
                }
                .subscribeOn(Schedulers.io())

        )
        .filter {
                return@filter it.isNotEmpty()
        }
        .first(emptyList())

    }

    fun freshHeadline(): Single<List<NewsDomainModel>>{
        return Single.fromObservable(service.fetchHeadlinesNews()).map { it.headlines.map { data ->  data.toDomainModel() } }
    }

//    fun streamedHeadlines(): Observable<List<NewsDomainModel>>{
//        return Observable.mergeDelayError(
//                service.fetchHeadlinesNews().map {
//                    it.headlines.map { data ->  data.toDomainModel() }
//                }
//                        .doOnNext {
//                            dao.insertMappedNews(1,"headlines",it.map { domain ->  domain.toEntity() })
//                        }
//                        .subscribeOn(Schedulers.io()),
//
//                dao.getNewsByCategoryAndPage(1,"headlines").map { entity ->
//                    entity.map { it.toDomainModel() }
//                }.subscribeOn(Schedulers.io())
//        )
//    }
}