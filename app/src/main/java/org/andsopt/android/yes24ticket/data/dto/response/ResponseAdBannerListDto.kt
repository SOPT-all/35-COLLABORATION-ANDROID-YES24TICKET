package org.andsopt.android.yes24ticket.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.andsopt.android.yes24ticket.domain.model.AdBannerEntity
import org.andsopt.android.yes24ticket.domain.model.AdBannerItem

@Serializable
data class ResponseAdBannerListDto(
    @SerialName("result")
    val result: String,
    @SerialName("ads")
    val ads: List<Ads>,
) {
    fun toAdBannerEntity() =
        AdBannerEntity(
            bannerLists =
                ads.map { adItem ->
                    AdBannerItem(
                        id = adItem.adsId,
                        imgUrl = adItem.adsImg,
                    )
                },
        )
}

@Serializable
data class Ads(
    @SerialName("ads_id")
    val adsId: Long,
    @SerialName("ads_img")
    val adsImg: String,
)
