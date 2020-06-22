package non.shahad.today.data.repository

import non.shahad.today.data.retrofit.response.TodayResponse

interface TodayRepository {
    suspend fun fetchLatestNews(page: Int) : TodayResponse
}