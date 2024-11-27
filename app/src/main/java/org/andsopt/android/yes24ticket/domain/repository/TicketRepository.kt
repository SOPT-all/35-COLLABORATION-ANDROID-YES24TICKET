package org.andsopt.android.yes24ticket.domain.repository

import org.andsopt.android.yes24ticket.domain.model.TicketDetailEntity
import org.andsopt.android.yes24ticket.domain.model.TicketDetailLikeEntity

interface TicketRepository {
    suspend fun getTicketDetail(
        ticketId: Int
    ): TicketDetailEntity

    suspend fun patchTicketDetailLike(
        ticketId: Int
    ): TicketDetailLikeEntity
}