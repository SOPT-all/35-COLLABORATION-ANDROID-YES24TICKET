package org.andsopt.android.yes24ticket.domain.repository

import org.andsopt.android.yes24ticket.data.dto.response.ResponseAdBannerListDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseMainBannerListDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseTicketRankingListDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseWhatsHotListDto

interface HomeRepository {
    suspend fun fetchMainBannerList(): Result<ResponseMainBannerListDto>

    suspend fun fetchTicketRankingList(): Result<ResponseTicketRankingListDto>

    suspend fun fetchWhatsHotList(): Result<ResponseWhatsHotListDto>

    suspend fun fetchAdBannerList(): Result<ResponseAdBannerListDto>
}