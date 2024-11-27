package org.andsopt.android.yes24ticket.presentation.ui.category.state

import org.andsopt.android.yes24ticket.domain.model.CategoryContentEntity

sealed interface CategoryDetailUiState {
    data class Success(val categoryContent: List<CategoryContentEntity>) : CategoryDetailUiState
    data object Loading : CategoryDetailUiState
    data class Error(val message: String?) : CategoryDetailUiState
}