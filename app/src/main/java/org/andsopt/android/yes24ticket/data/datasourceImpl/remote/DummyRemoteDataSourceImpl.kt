package org.andsopt.android.yes24ticket.data.datasourceImpl.remote

import org.andsopt.android.yes24ticket.data.datasource.remote.DummyRemoteDataSource
import org.andsopt.android.yes24ticket.data.dto.request.RequestDummyDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseDummyDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseDummyExampleDto
import org.andsopt.android.yes24ticket.data.service.DummyService
import org.andsopt.android.yes24ticket.util.base.BaseResponse
import javax.inject.Inject

class DummyRemoteDataSourceImpl
    @Inject
    constructor(
        private val dummyService: DummyService,
    ) : DummyRemoteDataSource {
        override suspend fun getDummyData(requestDummyDto: RequestDummyDto): BaseResponse<ResponseDummyDto> =
            dummyService.getDummyData(requestDummyDto)

        override suspend fun getDummyExampleDate(): ResponseDummyExampleDto =
            dummyService.getDummyExampleData()
    }
