package non.shahad.detail.data.repository

import non.shahad.detail.data.model.RequestDataModel
import non.shahad.detail.data.response.toDomainModel
import non.shahad.detail.data.retrofit.DetailService
import non.shahad.detail.domain.model.DetailDomainModel
import non.shahad.detail.domain.repository.DetailRepository
import javax.inject.Inject

internal class DetailRepositoryImpl @Inject constructor(
    private val service: DetailService
): DetailRepository{

    override suspend fun fetchDetail(url: String): DetailDomainModel {
        return service.fetchDetail("application/json",RequestDataModel(url)).toDomainModel()
    }

}