package org.andsopt.android.yes24ticket.presentation.ui.category.state

import org.andsopt.android.yes24ticket.presentation.type.FilterType

data class CategoryDetailBottomSheetState(
    val isBottomSheetVisible: Boolean = false,
    val selectedFilterType: FilterType? = null,
)
