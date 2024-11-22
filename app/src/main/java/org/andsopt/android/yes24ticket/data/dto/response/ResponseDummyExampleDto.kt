package org.andsopt.android.yes24ticket.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.andsopt.android.yes24ticket.domain.model.DummyEntity

@Serializable
data class ResponseDummyExampleDto(
    @SerialName("dummyA")
    val dummyA: String,
    @SerialName("dummyB")
    val dummyB: String,
    @SerialName("dummyC")
    val dummyC: String,
) {
    fun toDummyEntity() =
        DummyEntity(
            dummyA = dummyA,
            dummyB = dummyB,
            dummyC = dummyC,
        )
}
