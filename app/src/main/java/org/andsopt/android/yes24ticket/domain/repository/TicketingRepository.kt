package org.andsopt.android.yes24ticket.domain.repository

import org.andsopt.android.yes24ticket.domain.model.TicketAvailableTimesEntity
import org.andsopt.android.yes24ticket.domain.model.TimeSlotsDataEntity

interface TicketingRepository {

    suspend fun fetchAvailableTimes(ticketId: Int): TicketAvailableTimesEntity
    suspend fun fetchTimeSlots(concertId: String, performanceTime: String): TimeSlotsDataEntity
}