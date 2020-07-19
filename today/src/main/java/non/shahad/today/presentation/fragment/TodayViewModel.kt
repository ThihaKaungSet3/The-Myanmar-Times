package non.shahad.today.presentation.fragment


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dropbox.android.external.store4.StoreResponse
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import non.shahad.core.extensions.timber
import non.shahad.today.domain.model.NewsDomainModel
import non.shahad.today.domain.model.TodayDomainModel
import non.shahad.today.domain.repository.TodayRepository
import non.shahad.today.domain.usecase.TodayUseCase
import javax.inject.Inject

class TodayViewModel @Inject constructor(
    private val useCase: TodayUseCase
): ViewModel() {

    val feeds = MutableLiveData<List<NewsDomainModel>>()
    val newsByCategory = MutableLiveData<Pair<Int,List<NewsDomainModel>>>()

    var isLoading = false

    private val error = MutableLiveData<Throwable>()

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        error.postValue(throwable)
    }


    fun fetchLatestFresh() {
        isLoading = true
        viewModelScope.launch(errorHandler) {
            withContext(Dispatchers.IO){
                val latest = useCase.fetchFreshLatestNews()
                feeds.postValue(latest)
                isLoading = false
            }
        }
    }

    fun fetchNewsByCategoryFresh(page: Int){
        isLoading = true
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val res = useCase.fetchFreshNewsByCategory(page)
                newsByCategory.postValue(Pair(page,res))
                isLoading = false
            }
        }
    }

    fun streamNewsByCategory(page: Int){

        viewModelScope.launch (Dispatchers.IO){

            useCase.streamNewsByCategory(page).collect { response ->
                when(response){
                    is StoreResponse.Loading -> {isLoading = true}
                    is StoreResponse.Data -> {
                        val pair = Pair(page,response.value)
                        newsByCategory.postValue(pair)
                        isLoading = false
                    }
                    is StoreResponse.Error -> {
                        isLoading = false
                    }
                }
            }
        }
    }

    @InternalCoroutinesApi
    fun streamLatestNews(){
        viewModelScope.launch(Dispatchers.IO){
            useCase.streamLatestNews().collect { response ->
                when(response){
                    is StoreResponse.Loading -> isLoading = true
                    is StoreResponse.Data -> {
                        feeds.postValue(response.value)
                        isLoading = false
                    }
                    is StoreResponse.Error -> {
                        isLoading = false
                    }
                }
            }
        }
    }

}