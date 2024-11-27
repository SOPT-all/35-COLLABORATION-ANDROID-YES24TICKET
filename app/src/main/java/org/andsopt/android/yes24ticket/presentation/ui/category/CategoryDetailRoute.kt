package org.andsopt.android.yes24ticket.presentation.ui.category

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.andsopt.android.yes24ticket.presentation.ui.category.state.CategoryDetailUiState

@Composable
fun CategoryDetailRoute(
    viewModel: CategoryDetailViewModel = hiltViewModel(),
    moveToBackStack: () -> Unit,
) {
    val categoryDetailUiState by viewModel.categoryDetailUiState.collectAsStateWithLifecycle()
    val bottomSheetState by viewModel.bottomSheetState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.fetchCategoryDetails(filterType = null)
    }

    CategoryDetailScreen(
        categoryContentList = when (categoryDetailUiState) {
            is CategoryDetailUiState.Success -> (categoryDetailUiState as CategoryDetailUiState.Success).categoryContent
            else -> emptyList()
        },
        isBottomSheetVisible = bottomSheetState.isBottomSheetVisible,
        selectedFilterType = bottomSheetState.selectedFilterType,
        onSelectedFilterChanged = { newFilterType ->
            viewModel.apply {
                setFilterType(selectedFilterType = newFilterType)
                changeBottomSheetVisibility()
            }
        },
        onCloseButtonClick = { viewModel.changeBottomSheetVisibility() },
        onClickFilterSelector = viewModel::changeBottomSheetVisibility,
    )
}