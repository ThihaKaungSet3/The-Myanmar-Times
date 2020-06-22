package non.shahad.today.presentation.fragment


import androidx.lifecycle.ViewModel
import non.shahad.today.data.repository.TodayRepository
import non.shahad.today.data.repository.TodayRepositoryImpl
import javax.inject.Inject

class TodayViewModel @Inject constructor(
    private val repo: TodayRepository
): ViewModel() {
}