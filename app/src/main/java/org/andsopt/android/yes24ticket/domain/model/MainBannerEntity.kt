package org.andsopt.android.yes24ticket.domain.model

data class MainBannerItem(
    val id: Long,
    val title: String? = "",
    val area: String? = "",
    val date: String? = "",
    val imgUrl: String,
)

data class MainBannerEntity(
    val bannerLists : List<MainBannerItem>
)
