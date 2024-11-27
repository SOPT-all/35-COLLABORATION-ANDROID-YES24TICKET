package org.andsopt.android.yes24ticket.domain.repository

import org.andsopt.android.yes24ticket.domain.model.TicketDetailEntity

interface TicketRepository {
    suspend fun getTicketDetail(
        ticketId: Int
    ): TicketDetailEntity
}