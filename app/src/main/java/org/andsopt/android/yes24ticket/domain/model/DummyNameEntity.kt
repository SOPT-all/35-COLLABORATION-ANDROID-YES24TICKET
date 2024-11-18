package org.andsopt.android.yes24ticket.domain.model

import org.andsopt.android.yes24ticket.data.dto.request.RequestDummyDto

data class DummyNameEntity(
    val dummyName: String,
) {
    fun toRequestDummyDto() =
        RequestDummyDto(
            requestDummyName = dummyName,
        )
}
