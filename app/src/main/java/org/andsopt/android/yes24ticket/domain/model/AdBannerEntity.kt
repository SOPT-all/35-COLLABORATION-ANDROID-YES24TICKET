package org.andsopt.android.yes24ticket.domain.model

data class AdBannerItem(
    val id: Long,
    val imgUrl: String,
)

data class AdBannerEntity(
    val bannerLists: List<AdBannerItem>,
)
