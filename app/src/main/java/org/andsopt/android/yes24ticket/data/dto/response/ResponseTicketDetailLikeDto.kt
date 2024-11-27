package org.andsopt.android.yes24ticket.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.andsopt.android.yes24ticket.domain.model.TicketDetailLikeEntity

@Serializable
data class ResponseTicketDetailLikeDto(
    @SerialName("result")
    val result: String,
    @SerialName("concer_id")
    val concertId: String,
    @SerialName("number_of_likes")
    val likedCount: String,
    @SerialName("like")
    val isLiked: String,
) {
    fun toTicketDetailLikeEntity() =
        TicketDetailLikeEntity(
            concertId = concertId,
            likedCount = likedCount,
            isLiked = isLiked.toBoolean(),
        )
}
