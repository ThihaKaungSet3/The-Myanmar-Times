package non.shahad.today.data.store

import com.dropbox.android.external.store4.Store
import non.shahad.today.data.db.entities.NewsEntity
import non.shahad.today.data.model.NewsDataModel
import non.shahad.today.data.retrofit.response.NewsByCategoryResponse
import non.shahad.today.data.retrofit.response.TodayResponse
import non.shahad.today.domain.model.NewsDomainModel

internal typealias TodayStore = Store<Int, TodayResponse>
internal typealias NewsByCategoryStore = Store<Int,NewsByCategoryResponse>