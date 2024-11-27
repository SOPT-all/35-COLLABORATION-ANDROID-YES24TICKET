package org.andsopt.android.yes24ticket.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.andsopt.android.yes24ticket.domain.model.TicketDetailEntity
import org.andsopt.android.yes24ticket.domain.model.TicketPricingEntity

@Serializable
data class ResponseTicketDetailDto(
    @SerialName("result")
    val result: String,
    @SerialName("concert")
    val concert: TicketDetailDto
)

@Serializable
data class TicketDetailDto(
    @SerialName("concert_id")
    val concertId: String,
    @SerialName("concert_title")
    val concertTitle: String,
    @SerialName("concert_area")
    val concertArea: String,
    @SerialName("concert_img")
    val concertImg: String,
    @SerialName("concert_date")
    val concertDate: String,
    @SerialName("concert_duration")
    val concertDuration: String,
    @SerialName("concert_age")
    val concertAge: String,
    @SerialName("hypertext")
    val hyperText: String,
    @SerialName("hyperlink")
    val hyperlink: String,
    @SerialName("notice")
    val notice: List<String>,
    @SerialName("performance_times")
    val time: List<String>,
    @SerialName("ticket_pricing")
    val ticketPricing: List<TicketPricingDto>
) {
    @Serializable
    data class TicketPricingDto(
        @SerialName("type")
        val type: String,
        @SerialName("price")
        val price: String,
        @SerialName("color")
        val color: String
    ) {
        fun toTicketPricingEntity() = TicketPricingEntity(
            type = type,
            price = price,
            color = color
        )
    }

    fun toTicketDetailEntity() = TicketDetailEntity(
        ticketId = concertId,
        ticketTitle = concertTitle,
        ticketGenre = "콘서트",
        ticketArea = concertArea,
        ticketImg = concertImg,
        ticketDate = concertDate,
        ticketDuration = concertDuration,
        ticketAge = concertAge,
        ticketLikedCount = "162",
        ticketHyperText = hyperText,
        ticketNotice = notice,
        ticketPerformanceTimes = time,
        ticketPricing = ticketPricing.map { it.toTicketPricingEntity() },
    )
}

