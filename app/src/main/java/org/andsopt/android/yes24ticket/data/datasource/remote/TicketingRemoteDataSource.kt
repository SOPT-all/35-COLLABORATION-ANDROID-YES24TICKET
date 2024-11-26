package org.andsopt.android.yes24ticket.data.datasource.remote

import org.andsopt.android.yes24ticket.data.dto.request.RequestTimeSlotsDto
import org.andsopt.android.yes24ticket.data.service.TicketingService
import javax.inject.Inject

class TicketingRemoteDataSource @Inject constructor(
    private val ticketingService: TicketingService
) {

    suspend fun fetchAvailableTimes(ticketId: Int) = ticketingService.fetchAvailableTimes(ticketId)
    suspend fun fetchTimeSlots(requestTimeSlots: RequestTimeSlotsDto) =
        ticketingService.fetchTimeSlots(requestTimeSlots)
}