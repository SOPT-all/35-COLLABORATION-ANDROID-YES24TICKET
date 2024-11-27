package org.andsopt.android.yes24ticket.presentation.ui.category.state

import org.andsopt.android.yes24ticket.domain.model.CategoryContentEntity

data class CategoryDetailState (
    val categoryDetailList: List<CategoryContentEntity> = emptyList()
)