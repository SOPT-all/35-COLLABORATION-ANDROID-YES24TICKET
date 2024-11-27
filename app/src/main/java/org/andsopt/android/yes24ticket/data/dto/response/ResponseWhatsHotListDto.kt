package org.andsopt.android.yes24ticket.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.andsopt.android.yes24ticket.domain.model.WhatsHotEntity

data class ResponseWhatsHotListDto(
    @SerialName("result")
    val result: String,
    @SerialName("datas")
    val data: List<WhatsHot>
) {
    fun toWhatsHotEntity(): List<WhatsHotEntity> {
        return data.map { whatsHotItem ->
            WhatsHotEntity(
                id = whatsHotItem.ticketId,
                title = whatsHotItem.ticketTitle,
                area = whatsHotItem.ticketArea,
                date = whatsHotItem.ticketDate,
                imgUrl = whatsHotItem.ticketImg,
                comment = whatsHotItem.comment
            )
        }
    }
}
@Serializable
data class WhatsHot(
    @SerialName("ticket_id")
    val ticketId: Long,
    @SerialName("ticket_title")
    val ticketTitle: String,
    @SerialName("ticket_area")
    val ticketArea: String,
    @SerialName("ticket_date")
    val ticketDate: String,
    @SerialName("ticket_img")
    val ticketImg: String,
    @SerialName("comment")
    val comment: String? = ""
)