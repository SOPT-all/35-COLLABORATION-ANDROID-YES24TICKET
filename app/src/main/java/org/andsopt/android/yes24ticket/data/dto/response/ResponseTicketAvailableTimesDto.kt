package org.andsopt.android.yes24ticket.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.andsopt.android.yes24ticket.domain.model.TicketAvailableTimesEntity
import java.time.LocalDate

@Serializable
data class ResponseTicketAvailableTimesDto(
    @SerialName("performance_times")
    val performanceTimes: List<String>
) {
    fun toTicketAvailableTimes() = TicketAvailableTimesEntity(
        performanceTimes = performanceTimes.map {
            LocalDate.parse(it)
        }
    )
}