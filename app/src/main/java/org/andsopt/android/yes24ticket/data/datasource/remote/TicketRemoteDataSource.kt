package org.andsopt.android.yes24ticket.data.datasource.remote

import org.andsopt.android.yes24ticket.data.service.TicketService
import javax.inject.Inject

class TicketRemoteDataSource
    @Inject
    constructor(
        private val ticketService: TicketService,
    ) {
        suspend fun getTicketDetail(ticketId: Int) =
            ticketService.getTicketDetail(ticketId)

        suspend fun patchTicketLike(ticketId: Int) =
            ticketService.patchTicketLike(ticketId)
    }
