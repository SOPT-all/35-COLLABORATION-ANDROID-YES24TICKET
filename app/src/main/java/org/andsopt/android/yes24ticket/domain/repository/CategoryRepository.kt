package org.andsopt.android.yes24ticket.domain.repository

import org.andsopt.android.yes24ticket.domain.model.CategoryContentEntity

interface CategoryRepository {
    suspend fun getCategoryDetailList(
        sortBy: String?
    ): List<CategoryContentEntity>
}