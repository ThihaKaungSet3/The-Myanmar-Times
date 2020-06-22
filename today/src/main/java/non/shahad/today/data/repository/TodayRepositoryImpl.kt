package non.shahad.today.data.repository

import non.shahad.today.data.retrofit.service.TodayService
import javax.inject.Inject

 class TodayRepositoryImpl @Inject constructor(
    private val service: TodayService
) : TodayRepository{

    override suspend fun fetchLatestNews(page: Int) =
         service.fetchLatestNews(page)


}