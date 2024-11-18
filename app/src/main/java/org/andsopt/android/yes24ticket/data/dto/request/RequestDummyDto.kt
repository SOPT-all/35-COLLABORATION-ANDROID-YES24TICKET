package org.andsopt.android.yes24ticket.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestDummyDto(
    @SerialName("dummyName")
    val requestDummyName: String,
)
