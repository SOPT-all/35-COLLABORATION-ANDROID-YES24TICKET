package org.andsopt.android.yes24ticket.data.repositoryImpl

import org.andsopt.android.yes24ticket.data.datasource.remote.HomeRemoteDataSource
import org.andsopt.android.yes24ticket.data.dto.response.ResponseAdBannerListDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseMainBannerListDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseTicketRankingListDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseWhatsHotListDto
import org.andsopt.android.yes24ticket.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl
@Inject constructor(
    private val homeRemoteDataSource: HomeRemoteDataSource
) : HomeRepository {
    override suspend fun fetchMainBannerList(): Result<ResponseMainBannerListDto> {

        }

    override suspend fun fetchTicketRankingList(): Result<ResponseTicketRankingListDto> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchWhatsHotList(): Result<ResponseWhatsHotListDto> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchAdBannerList(): Result<ResponseAdBannerListDto> {
        TODO("Not yet implemented")
    }
}