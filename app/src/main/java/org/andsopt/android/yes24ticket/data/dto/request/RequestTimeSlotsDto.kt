package org.andsopt.android.yes24ticket.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestTimeSlotsDto(
    @SerialName("concert_id")
    val concertId: String,
    @SerialName("performance_time")
    val performanceTime: String,
)
