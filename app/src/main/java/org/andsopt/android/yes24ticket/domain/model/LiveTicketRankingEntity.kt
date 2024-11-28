package org.andsopt.android.yes24ticket.domain.model

data class LiveTicketRankingItem(
    val id: Long,
    val rank: Long,
    val imgUrl: String,
)

data class LiveTicketRankingEntity(
    val bannerLists: List<LiveTicketRankingItem>,
)
