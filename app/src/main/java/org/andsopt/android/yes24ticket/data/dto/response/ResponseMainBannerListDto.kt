package org.andsopt.android.yes24ticket.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.andsopt.android.yes24ticket.domain.model.MainBannerEntity

@Serializable
data class ResponseMainBannerListDto(
    @SerialName("result")
    val result: String,
    @SerialName("datas")
    val data: List<MainTicket>
) {
    fun toMainBannerEntity(): List<MainBannerEntity> {
        return data.map { mainBannerItem ->
            MainBannerEntity(
                id = mainBannerItem.ticketId,
                title = mainBannerItem.ticketTitle,
                area = mainBannerItem.ticketArea,
                date = mainBannerItem.ticketDate,
                imgUrl = mainBannerItem.ticketImg
            )
        }
    }

}

@Serializable
data class MainTicket(
    @SerialName("ticket_id")
    val ticketId: Long,
    @SerialName("ticket_area")
    val ticketArea: String,
    @SerialName("ticket_title")
    val ticketTitle: String,
    @SerialName("ticket_date")
    val ticketDate: String,
    @SerialName("ticket_img")
    val ticketImg: String
)


