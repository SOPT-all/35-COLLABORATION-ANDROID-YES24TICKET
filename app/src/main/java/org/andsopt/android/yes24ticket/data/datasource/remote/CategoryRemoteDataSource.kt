package org.andsopt.android.yes24ticket.data.datasource.remote

import org.andsopt.android.yes24ticket.data.service.CategoryService
import javax.inject.Inject

class CategoryRemoteDataSource @Inject constructor(
    private val categoryService: CategoryService
) {
    suspend fun getCategoryDetailList(sortBy: String? = null) = categoryService.getCategoryDetailList(sortBy)
}