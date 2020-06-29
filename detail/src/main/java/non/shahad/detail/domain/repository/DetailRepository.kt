package non.shahad.detail.domain.repository

import non.shahad.detail.domain.model.DetailDomainModel

interface DetailRepository {
    suspend fun fetchDetail(url: String): DetailDomainModel
}