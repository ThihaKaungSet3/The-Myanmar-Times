package non.shahad.detail.domain.usecase

import kotlinx.coroutines.Dispatchers
import non.shahad.core.network.ResultWrapper
import non.shahad.core.network.safeApiCall
import non.shahad.detail.domain.model.DetailDomainModel
import non.shahad.detail.domain.repository.DetailRepository
import javax.inject.Inject

class NewsDetailUseCase @Inject constructor(
    private val repository: DetailRepository
) {

    suspend fun fetchNewsDetail(url: String): ResultWrapper<DetailDomainModel> {
        return safeApiCall(Dispatchers.IO){repository.fetchDetail(url)}
    }
}