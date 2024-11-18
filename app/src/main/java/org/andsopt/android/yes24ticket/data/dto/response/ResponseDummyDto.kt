package org.andsopt.android.yes24ticket.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.andsopt.android.yes24ticket.domain.model.DummyIdEntity

@Serializable
data class ResponseDummyDto(
    @SerialName("dummy")
    val responseDummyId: Long
) {
    fun toDummyIdEntity() = DummyIdEntity(
        dummyId = responseDummyId.toString()
    )
}
