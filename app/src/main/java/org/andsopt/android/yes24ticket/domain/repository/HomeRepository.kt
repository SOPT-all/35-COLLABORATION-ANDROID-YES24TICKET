package org.andsopt.android.yes24ticket.domain.repository

import org.andsopt.android.yes24ticket.domain.model.AdBannerEntity
import org.andsopt.android.yes24ticket.domain.model.LiveTicketRankingEntity
import org.andsopt.android.yes24ticket.domain.model.MainBannerEntity
import org.andsopt.android.yes24ticket.domain.model.WhatsHotEntity

interface HomeRepository {
    suspend fun fetchMainBannerList(): Result<MainBannerEntity>

    suspend fun fetchTicketRankingList(): Result<LiveTicketRankingEntity>

    suspend fun fetchWhatsHotList(): Result<WhatsHotEntity>

    suspend fun fetchAdBannerList(): Result<AdBannerEntity>
}
