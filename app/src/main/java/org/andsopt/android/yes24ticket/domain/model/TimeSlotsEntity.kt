package org.andsopt.android.yes24ticket.domain.model


data class TimeSlotsDataEntity(
    val slots: List<TimeSlots>
)

data class TimeSlots(
    val performanceTime: String,
    val remainingSeats: List<RemainingSeat>
)

data class RemainingSeat(
    val type: String,
    val remainingSeats: String
)
