package org.andsopt.android.yes24ticket.data.service

import org.andsopt.android.yes24ticket.data.dto.response.ResponseCategoryDto
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.LIST
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.SORT_BY
import org.andsopt.android.yes24ticket.util.constants.ApiConstants.TICKETS
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryService {
    @GET("$TICKETS/$LIST")
    suspend fun getCategoryDetailList(
        @Query(SORT_BY) sortBy: String?,
    ): ResponseCategoryDto
}
