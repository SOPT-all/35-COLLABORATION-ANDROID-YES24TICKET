package org.andsopt.android.yes24ticket.data.service

import org.andsopt.android.yes24ticket.data.dto.request.RequestTimeSlotsDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseTicketAvailableTimesDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseTimeSlotsDataDto
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.AVAILABLE_DATE
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.AVAILABLE_TIME_SLOTS
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TicketingService {
    @GET("$TICKETS/${AVAILABLE_DATE}/{ticket_id}")
    suspend fun fetchAvailableTimes(
        @Path("ticket_id") ticketId: Int,
    ): ResponseTicketAvailableTimesDto

    @POST("$TICKETS/${AVAILABLE_TIME_SLOTS}")
    suspend fun fetchTimeSlots(
        @Body requestTimeSlots: RequestTimeSlotsDto,
    ): ResponseTimeSlotsDataDto
}
