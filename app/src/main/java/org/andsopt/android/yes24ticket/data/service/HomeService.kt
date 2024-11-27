package org.andsopt.android.yes24ticket.data.service

import org.andsopt.android.yes24ticket.data.dto.response.ResponseAdBannerListDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseMainBannerListDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseTicketRankingListDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseWhatsHotListDto
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.ADS
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.HOT
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.MAIN
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.RANKED
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.TICKETS
import retrofit2.http.GET

interface HomeService {
    @GET("/$TICKETS/$MAIN")
    suspend fun fetchMainBannerList(): ResponseMainBannerListDto

    @GET("/$TICKETS/$RANKED")
    suspend fun fetchTicketRankingList(): ResponseTicketRankingListDto

    @GET("/$TICKETS/$HOT")
    suspend fun fetchWhatsHotList(): ResponseWhatsHotListDto

    @GET("/$ADS")
    suspend fun fetchAdBannerList(): ResponseAdBannerListDto
}