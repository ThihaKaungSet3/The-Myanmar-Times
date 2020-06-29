package non.shahad.today.data.db.daos

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import non.shahad.today.data.db.entities.NewsEntity

@Dao
internal abstract class TodayNewsDao {

    @Query("SELECT * FROM today_news WHERE page = :page")
    abstract fun getNewsByPage(page: Int): Flow<List<NewsEntity>>

    @Query("DELETE FROM today_news WHERE id = :page")
    abstract fun clearNewsByPage(page: Int)

    @Query("DELETE FROM today_news")
    abstract suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    internal abstract fun insertNews(news: List<NewsEntity>)

    @Transaction
    suspend fun insertMappedNews(page: Int,category: String,news: List<NewsEntity>){
        clearNewsByPage(page)

        val feeds  = news.mapIndexed { index, newsEntity ->
            newsEntity.also {
                it.page = page
                it.categoryName = category
            }
        }

        insertNews(feeds)

    }


}