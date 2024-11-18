package org.andsopt.android.yes24ticket.domain.repository

import org.andsopt.android.yes24ticket.domain.model.DummyIdEntity
import org.andsopt.android.yes24ticket.domain.model.DummyNameEntity

interface DummyRepository {
    suspend fun getDummyData(dummyNameEntity: DummyNameEntity): Result<DummyIdEntity>
}
