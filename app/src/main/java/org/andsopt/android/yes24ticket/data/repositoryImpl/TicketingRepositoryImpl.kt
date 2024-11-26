package org.andsopt.android.yes24ticket.data.repositoryImpl

import org.andsopt.android.yes24ticket.data.datasource.remote.TicketingRemoteDataSource
import org.andsopt.android.yes24ticket.data.dto.request.RequestTimeSlotsDto
import org.andsopt.android.yes24ticket.domain.model.TicketAvailableTimesEntity
import org.andsopt.android.yes24ticket.domain.model.TimeSlotsDataEntity
import org.andsopt.android.yes24ticket.domain.repository.TicketingRepository
import javax.inject.Inject

class TicketingRepositoryImpl
    @Inject
    constructor(
        private val ticketingRemoteDataSource: TicketingRemoteDataSource,
    ) : TicketingRepository {
        override suspend fun fetchAvailableTimes(ticketId: Int): TicketAvailableTimesEntity {
            return ticketingRemoteDataSource.fetchAvailableTimes(ticketId).toTicketAvailableTimes()
        }

        override suspend fun fetchTimeSlots(
            concertId: String,
            performanceTime: String,
        ): TimeSlotsDataEntity {
            return ticketingRemoteDataSource.fetchTimeSlots(
                RequestTimeSlotsDto(
                    concertId = concertId,
                    performanceTime = performanceTime,
                ),
            ).toTimeSlotsData()
        }
    }
