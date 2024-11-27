package org.andsopt.android.yes24ticket.data.repositoryImpl

import org.andsopt.android.yes24ticket.data.datasource.remote.CategoryRemoteDataSource
import org.andsopt.android.yes24ticket.domain.model.CategoryContentEntity
import org.andsopt.android.yes24ticket.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl
    @Inject
    constructor(
        private val categoryRemoteDataSource: CategoryRemoteDataSource,
    ) : CategoryRepository {
        override suspend fun getCategoryDetailList(sortBy: String?): List<CategoryContentEntity> =
            categoryRemoteDataSource.getCategoryDetailList(sortBy).concerts.map { it.toCategoryContentEntity() }
    }
