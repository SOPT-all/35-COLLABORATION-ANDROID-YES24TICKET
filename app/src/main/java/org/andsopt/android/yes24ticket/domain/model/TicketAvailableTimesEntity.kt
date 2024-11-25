package org.andsopt.android.yes24ticket.domain.model

import java.time.LocalDate

data class TicketAvailableTimesEntity(
    val performanceTimes: List<LocalDate>
)