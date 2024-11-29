package org.andsopt.android.yes24ticket.data.service

import org.andsopt.android.yes24ticket.data.dto.request.RequestTimeSlotsDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseTicketAvailableTimesDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseTimeSlotsDataDto
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.AVAILABLE_DATE
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.AVAILABLE_TIME_SLOTS
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.TICKETS
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.TICKET_ID
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TicketingService {
    @GET("$TICKETS/${AVAILABLE_DATE}/{${TICKET_ID}}")
    suspend fun fetchAvailableTimes(
        @Path(TICKET_ID) ticketId: Int,
    ): ResponseTicketAvailableTimesDto

    @POST("$TICKETS/${AVAILABLE_TIME_SLOTS}")
    suspend fun fetchTimeSlots(
        @Body requestTimeSlots: RequestTimeSlotsDto,
    ): ResponseTimeSlotsDataDto
}
