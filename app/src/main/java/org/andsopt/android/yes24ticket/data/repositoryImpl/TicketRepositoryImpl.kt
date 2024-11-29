package org.andsopt.android.yes24ticket.data.repositoryImpl

import org.andsopt.android.yes24ticket.data.datasource.remote.TicketRemoteDataSource
import org.andsopt.android.yes24ticket.domain.model.TicketDetailEntity
import org.andsopt.android.yes24ticket.domain.model.TicketDetailLikeEntity
import org.andsopt.android.yes24ticket.domain.repository.TicketRepository
import javax.inject.Inject

class TicketRepositoryImpl
    @Inject
    constructor(
        private val ticketRemoteDataSource: TicketRemoteDataSource,
    ) : TicketRepository {
        override suspend fun getTicketDetail(ticketId: Int): TicketDetailEntity =
            ticketRemoteDataSource.getTicketDetail(ticketId).concert.toTicketDetailEntity()

        override suspend fun patchTicketDetailLike(ticketId: Int): TicketDetailLikeEntity =
            ticketRemoteDataSource.patchTicketLike(ticketId).toTicketDetailLikeEntity()
    }
