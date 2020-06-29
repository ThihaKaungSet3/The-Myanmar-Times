package non.shahad.today.presentation.fragment


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import non.shahad.core.extensions.timber
import non.shahad.today.domain.model.NewsDomainModel
import non.shahad.today.domain.model.TodayDomainModel
import non.shahad.today.domain.repository.TodayRepository
import non.shahad.today.domain.usecase.TodayUseCase
import javax.inject.Inject

class TodayViewModel @Inject constructor(
    private val useCase: TodayUseCase
): ViewModel() {

    val feeds = MutableLiveData<TodayDomainModel>()
    val newsByCategory = MutableLiveData<List<NewsDomainModel>>()

    var isLoading = false

    val error = MutableLiveData<Throwable>()

    val errorHandler = CoroutineExceptionHandler { _, throwable ->
        error.postValue(throwable)
    }

    fun fetchTodayFeeds(page: Int) {
        isLoading = true
        viewModelScope.launch(errorHandler) {
            withContext(Dispatchers.IO){
                val latest = useCase.fetchLatestNews(page)
                feeds.postValue(latest)
                isLoading = false
            }
        }
    }

    fun fetchNewsByCategory(page: Int){
        isLoading = true
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val res = useCase.fetchNewsByCategory(page)
                newsByCategory.postValue(res)
                isLoading = false
            }
        }
    }

}