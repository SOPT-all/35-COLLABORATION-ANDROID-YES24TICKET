package org.andsopt.android.yes24ticket.data.repositoryImpl

import org.andsopt.android.yes24ticket.data.datasource.remote.HomeRemoteDataSource
import org.andsopt.android.yes24ticket.domain.model.AdBannerEntity
import org.andsopt.android.yes24ticket.domain.model.LiveTicketRankingEntity
import org.andsopt.android.yes24ticket.domain.model.MainBannerEntity
import org.andsopt.android.yes24ticket.domain.model.WhatsHotEntity
import org.andsopt.android.yes24ticket.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl
    @Inject
    constructor(
        private val homeRemoteDataSource: HomeRemoteDataSource,
    ) : HomeRepository {
        override suspend fun fetchMainBannerList(): Result<MainBannerEntity> =
            runCatching {
                homeRemoteDataSource.fetchMainBannerList().toMainBannerEntity()
            }

        override suspend fun fetchTicketRankingList(): Result<LiveTicketRankingEntity> =
            runCatching {
                homeRemoteDataSource.fetchTicketRankingList().toLiveTicketRankingEntity()
            }

        override suspend fun fetchWhatsHotList(): Result<WhatsHotEntity> =
            runCatching {
                homeRemoteDataSource.fetchWhatsHotList().toWhatsHotEntity()
            }

        override suspend fun fetchAdBannerList(): Result<AdBannerEntity> =
            runCatching {
                homeRemoteDataSource.fetchAdBannerList().toAdBannerEntity()
            }
    }
