package non.shahad.detail.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import non.shahad.core.extensions.timber
import non.shahad.core.network.ResultWrapper
import non.shahad.detail.domain.model.DetailDomainModel
import non.shahad.detail.domain.usecase.NewsDetailUseCase
import javax.inject.Inject

class NewsDetailViewModel @Inject constructor(
    private val useCase: NewsDetailUseCase
) : ViewModel() {

    val response = MutableLiveData<DetailDomainModel>()

    fun fetchDetail(url: String) {
        viewModelScope.launch {
            when(val result = useCase.fetchNewsDetail(url)){
                is ResultWrapper.NetworkError -> {
                    timber("Detail_","Network")
                }
                is ResultWrapper.GenericError -> {
                    timber("Detail_","${result.code}")
                }
                is ResultWrapper.Success -> response.postValue(result.value)
            }
        }
    }
}