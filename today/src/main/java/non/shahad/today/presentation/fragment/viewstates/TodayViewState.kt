package non.shahad.today.presentation.fragment.viewstates

import non.shahad.today.domain.model.NewsDomainModel

data class TodayViewState(
    val viewStatus: TodayViewStatus,
    val news: List<NewsDomainModel> = emptyList()
)

sealed class TodayViewStatus
object IDLE: TodayViewStatus()
object LOADING: TodayViewStatus()
object SUCCESS: TodayViewStatus()