package org.andsopt.android.yes24ticket.data.service

import org.andsopt.android.yes24ticket.data.dto.response.ResponseTicketDetailDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseTicketDetailLikeDto
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.DETAILS
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.LIKE
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.TICKETS
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.TICKET_ID
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface TicketService {
    @GET("$TICKETS/$DETAILS/{$TICKET_ID}")
    suspend fun getTicketDetail(
        @Path(TICKET_ID) ticketId: Int,
    ): ResponseTicketDetailDto

    @PATCH("$TICKETS/$LIKE/{$TICKET_ID}")
    suspend fun patchTicketLike(
        @Path(TICKET_ID) ticketId: Int,
    ): ResponseTicketDetailLikeDto
}
