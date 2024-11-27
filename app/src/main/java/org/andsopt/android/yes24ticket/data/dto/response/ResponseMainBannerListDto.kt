package org.andsopt.android.yes24ticket.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.andsopt.android.yes24ticket.domain.model.MainBannerEntity
import org.andsopt.android.yes24ticket.domain.model.MainBannerItem

@Serializable
data class ResponseMainBannerListDto(
    @SerialName("result")
    val result: String,
    @SerialName("datas")
    val data: List<MainTicket>,
) {
    fun toMainBannerEntity() =
        MainBannerEntity(
            bannerLists =
                data.map { mainBannerItem ->
                    MainBannerItem(
                        id = mainBannerItem.ticketId,
                        title = mainBannerItem.ticketTitle,
                        area = mainBannerItem.ticketArea,
                        date = mainBannerItem.ticketDate,
                        imgUrl = mainBannerItem.ticketImg,
                    )
                },
        )
}

@Serializable
data class MainTicket(
    @SerialName("ticketId")
    val ticketId: Long,
    @SerialName("area")
    val ticketArea: String? = "",
    @SerialName("title")
    val ticketTitle: String? = "",
    @SerialName("period")
    val ticketDate: String? = "",
    @SerialName("img")
    val ticketImg: String,
)
