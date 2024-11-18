package org.andsopt.android.yes24ticket.data.repositoryImpl

import org.andsopt.android.yes24ticket.data.datasource.remote.DummyRemoteDataSource
import org.andsopt.android.yes24ticket.domain.model.DummyIdEntity
import org.andsopt.android.yes24ticket.domain.model.DummyNameEntity
import org.andsopt.android.yes24ticket.domain.repository.DummyRepository
import javax.inject.Inject

class DummyRepositoryImpl
    @Inject
    constructor(
        private val dummyRemoteDataSource: DummyRemoteDataSource,
    ) : DummyRepository {
        override suspend fun getDummyData(dummyNameEntity: DummyNameEntity): Result<DummyIdEntity> =
            runCatching {
                dummyRemoteDataSource.getDummyData(requestDummyDto = dummyNameEntity.toRequestDummyDto()).data.toDummyIdEntity()
            }
    }
