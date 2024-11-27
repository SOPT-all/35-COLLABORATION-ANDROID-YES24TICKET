package org.andsopt.android.yes24ticket.data.dto.response

import androidx.compose.ui.tooling.data.EmptyGroup.data
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.andsopt.android.yes24ticket.domain.model.AdBannerEntity
import org.andsopt.android.yes24ticket.domain.model.MainBannerEntity

@Serializable
data class ResponseAdBannerListDto(
    @SerialName("result")
    val result: String,
    @SerialName("ads")
    val ads: List<Ads>
) {
    fun toADdBannerEntity(): List<AdBannerEntity> {
        return ads.map { adItem ->
            AdBannerEntity(
                id = adItem.adsId,
                imgUrl = adItem.adsImg
            )
        }
    }
}

@Serializable
data class Ads(
    @SerialName("ads_id")
    val adsId: String,
    @SerialName("ads_img")
    val adsImg: String
)
