package non.shahad.today.data.db.daos

import androidx.room.*
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import non.shahad.today.data.db.entities.NewsEntity
import timber.log.Timber

@Dao
internal abstract class TodayNewsDao {

    @Query("SELECT * FROM today_news WHERE page = :page AND category = :category")
    abstract fun getNewsByCategoryAndPage(
            page: Int,
            category: String
    ): Observable<List<NewsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertNews(news: List<NewsEntity>)

    @Query("DELETE FROM today_news WHERE page = :page AND category = :category")
    abstract fun clearNewsByPageAndCategory(page: Int,category: String)

    @Transaction
    open fun insertMappedNews(page: Int,category: String,news: List<NewsEntity>){
//        clearNewsByPageAndCategory(page, category)
        val current = System.currentTimeMillis()

        val feeds  = news.mapIndexed { _, newsEntity ->
            newsEntity.also {
                it.page = page
                it.lastUpdated = current
            }
        }

        insertNews(feeds)
    }

//    @Query("SELECT * FROM today_news WHERE page = :page")
//    abstract fun getNewsByPage(page: Int): Flow<List<NewsEntity>>
//
//    @Query("SELECT * FROM today_news WHERE category_name = :name")
//    abstract fun getLatestNews(name: String): Flow<List<NewsEntity>>
//
//    @Query("DELETE FROM today_news WHERE id = :page")
//    abstract fun clearNewsByPage(page: Int)
//
//    @Query("DELETE FROM today_news WHERE category_name = :name")
//    abstract fun clearNewsByName(name: String)
//
//    @Query("DELETE FROM today_news")
//    abstract suspend fun deleteAll()
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    internal abstract fun insertNews(news: List<NewsEntity>)
//
//    @Transaction
//    open fun insertMappedNews(page: Int,news: List<NewsEntity>){
//        clearNewsByPage(page)
//
//        val feeds  = news.mapIndexed { _, newsEntity ->
//            newsEntity.also {
//                it.page = page
//            }
//        }
//
//        insertNews(feeds)
//
//    }
//
//    @Transaction
//    open fun insertLatestNews(news: List<NewsEntity>){
//        clearNewsByName("latest")
//
//        val feeds = news.mapIndexed { _, newsEntity ->
//            newsEntity.also {
//                it.categoryName = "latest"
//            }
//        }
//
//        insertNews(feeds)
//    }

}