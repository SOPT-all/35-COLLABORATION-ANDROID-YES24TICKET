package org.andsopt.android.yes24ticket.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.andsopt.android.yes24ticket.domain.model.CategoryContentEntity

@Serializable
data class ResponseCategoryDto(
    @SerialName("result")
    val result: String,
    @SerialName("concerts")
    val concerts: List<CategoryDetailDto>
)
@kotlinx.serialization.Serializable
data class CategoryDetailDto(
    @SerialName("concert_id")
    val concertId: Long,
    @SerialName("concert_title")
    val concertTitle: String,
    @SerialName("concert_area")
    val concertArea: String,
    @SerialName("concert_date")
    val concertDate: String,
    @SerialName("concert_img")
    val concertImg: String,
) {
    fun toCategoryContentEntity() =
        CategoryContentEntity(
            contentId = concertId,
            contentImg = concertImg,
            contentTitle = concertTitle,
            contentPlace = concertArea,
            contentPeriod = concertDate
        )
}