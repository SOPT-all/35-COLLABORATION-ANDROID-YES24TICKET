package org.andsopt.android.yes24ticket.data.service

import org.andsopt.android.yes24ticket.data.dto.request.RequestDummyDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseDummyDto
import org.andsopt.android.yes24ticket.util.base.BaseResponse
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.DUMMY
import retrofit2.http.Body
import retrofit2.http.GET

interface DummyService {
    @GET("/$DUMMY")
    suspend fun getDummyData(
        @Body body: RequestDummyDto,
    ): BaseResponse<ResponseDummyDto>
}
