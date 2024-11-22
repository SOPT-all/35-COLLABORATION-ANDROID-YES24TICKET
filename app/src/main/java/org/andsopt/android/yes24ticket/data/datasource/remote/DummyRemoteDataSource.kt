package org.andsopt.android.yes24ticket.data.datasource.remote

import org.andsopt.android.yes24ticket.data.dto.request.RequestDummyDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseDummyDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseDummyExampleDto
import org.andsopt.android.yes24ticket.util.base.BaseResponse

interface DummyRemoteDataSource {
    suspend fun getDummyData(requestDummyDto: RequestDummyDto): BaseResponse<ResponseDummyDto>

    suspend fun getDummyExampleDate(): ResponseDummyExampleDto
}
