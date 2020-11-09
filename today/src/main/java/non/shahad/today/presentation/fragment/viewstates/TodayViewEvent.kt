package non.shahad.today.presentation.fragment.viewstates

sealed class TodayViewEvent

data class fetchNextPage(
    val page: Int,
    val category: String
): TodayViewEvent()