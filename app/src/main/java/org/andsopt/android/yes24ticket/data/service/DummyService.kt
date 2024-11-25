package org.andsopt.android.yes24ticket.data.service

import org.andsopt.android.yes24ticket.data.dto.request.RequestDummyDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseDummyDto
import org.andsopt.android.yes24ticket.data.dto.response.ResponseDummyExampleDto
import org.andsopt.android.yes24ticket.util.base.BaseResponse
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.DUMMY
import retrofit2.http.Body
import retrofit2.http.GET

interface DummyService {
    @GET("/$DUMMY")
    suspend fun getDummyData(
        @Body body: RequestDummyDto,
    ): BaseResponse<ResponseDummyDto>

    @GET("/DUMMY-EXAMPLE") // 어차피 지울 거라 상수화 안 할게요!
    suspend fun getDummyExampleData(): ResponseDummyExampleDto
}
