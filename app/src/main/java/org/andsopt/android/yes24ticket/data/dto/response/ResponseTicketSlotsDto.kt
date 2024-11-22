package org.andsopt.android.yes24ticket.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.andsopt.android.yes24ticket.domain.model.TicketSlotsEntity
import java.time.LocalDate

@Serializable
data class ResponseTicketSlotsDto(
    @SerialName("performanceTimes")
    val performanceTimes: List<String>
) {
    fun toTicketSlotsEntity() = TicketSlotsEntity(
        performanceTimes = performanceTimes.map {
            LocalDate.parse(it)
        }
    )
}