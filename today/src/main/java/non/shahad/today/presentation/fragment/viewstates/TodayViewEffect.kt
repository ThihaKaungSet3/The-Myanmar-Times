package non.shahad.today.presentation.fragment.viewstates

sealed class TodayViewEffect
data class showError(val message: String): TodayViewEffect()