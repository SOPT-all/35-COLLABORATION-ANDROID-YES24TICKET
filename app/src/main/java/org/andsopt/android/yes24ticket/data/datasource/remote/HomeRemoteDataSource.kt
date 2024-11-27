package org.andsopt.android.yes24ticket.data.datasource.remote

import org.andsopt.android.yes24ticket.data.dto.response.ResponseAdBannerListDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseMainBannerListDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseTicketRankingListDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseWhatsHotListDto
import org.andsopt.android.yes24ticket.data.service.HomeService
import javax.inject.Inject

class HomeRemoteDataSource
    @Inject
    constructor(
        private val homeService: HomeService,
    ) {
        suspend fun fetchMainBannerList(): ResponseMainBannerListDto =
            homeService.fetchMainBannerList()

        suspend fun fetchTicketRankingList(): ResponseTicketRankingListDto =
            homeService.fetchTicketRankingList()

        suspend fun fetchWhatsHotList(): ResponseWhatsHotListDto =
            homeService.fetchWhatsHotList()

        suspend fun fetchAdBannerList(): ResponseAdBannerListDto =
            homeService.fetchAdBannerList()
    }
