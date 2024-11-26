package org.andsopt.android.yes24ticket.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.andsopt.android.yes24ticket.domain.model.RemainingSeat
import org.andsopt.android.yes24ticket.domain.model.TimeSlots
import org.andsopt.android.yes24ticket.domain.model.TimeSlotsDataEntity

@Serializable
data class ResponseTimeSlotsDataDto(
    @SerialName("data")
    val data: List<ResponseTimeSlotsDto>,
) {
    fun toTimeSlotsData() =
        TimeSlotsDataEntity(
            slots =
                data.map {
                    TimeSlots(
                        performanceTime = it.performanceTime,
                        remainingSeats =
                            it.remainingSeats.map {
                                RemainingSeat(
                                    type = it.type,
                                    remainingSeats = it.remainingSeats,
                                )
                            },
                    )
                },
        )
}

@Serializable
data class ResponseTimeSlotsDto(
    @SerialName("performance_time")
    val performanceTime: String,
    @SerialName("remaining_seats")
    val remainingSeats: List<ResponseRemainingSeatDto>,
)

@Serializable
data class ResponseRemainingSeatDto(
    @SerialName("type")
    val type: String,
    @SerialName("remaining")
    val remainingSeats: String,
)
