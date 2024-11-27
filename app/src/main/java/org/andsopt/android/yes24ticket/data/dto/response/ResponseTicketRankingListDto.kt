package org.andsopt.android.yes24ticket.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.andsopt.android.yes24ticket.domain.model.LiveTicketRankingEntity
import org.andsopt.android.yes24ticket.domain.model.LiveTicketRankingItem

@Serializable
data class ResponseTicketRankingListDto(
    @SerialName("result")
    val result: String,
    @SerialName("ranking")
    val ranking: List<TicketRanking>,
) {
    fun toLiveTicketRankingEntity() =
        LiveTicketRankingEntity(
            bannerLists =
                ranking.map { ticket ->
                    LiveTicketRankingItem(
                        id = ticket.ticketId,
                        rank = ticket.rank,
                        imgUrl = ticket.imgUrl,
                    )
                },
        )
}

@Serializable
data class TicketRanking(
    @SerialName("rank")
    val rank: Long,
    @SerialName("ticket_id")
    val ticketId: Long,
    @SerialName("img_url")
    val imgUrl: String,
)
