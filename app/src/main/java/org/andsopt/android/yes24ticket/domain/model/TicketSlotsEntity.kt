package org.andsopt.android.yes24ticket.domain.model

import java.time.LocalDate

data class TicketSlotsEntity(
    val performanceTimes: List<LocalDate>
)