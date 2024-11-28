package org.andsopt.android.yes24ticket.presentation.ui.category

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.andsopt.android.yes24ticket.presentation.ui.category.state.CategoryDetailUiState

@Composable
fun CategoryDetailRoute(
    viewModel: CategoryDetailViewModel = hiltViewModel(),
    moveToBackStack: () -> Unit,
) {
    val bottomSheetState by viewModel.bottomSheetState.collectAsStateWithLifecycle()
    val categoryDetailUiState by viewModel.categoryDetailUiState.collectAsStateWithLifecycle()
    val categoryDetailState by viewModel.categoryDetailState.collectAsStateWithLifecycle()

    when (categoryDetailUiState) {
        is CategoryDetailUiState.Success -> {
            CategoryDetailScreen(
                categoryContentList = categoryDetailState.categoryDetailList,
                isBottomSheetVisible = bottomSheetState.isBottomSheetVisible,
                selectedFilterType = bottomSheetState.selectedFilterType,
                onSelectedFilterChanged = { newFilterType ->
                    viewModel.apply {
                        setFilterType(selectedFilterType = newFilterType)
                        changeBottomSheetVisibility()
                    }
                },
                onCloseButtonClick = { viewModel.changeBottomSheetVisibility() },
                onClickFilterSelector = { viewModel.changeBottomSheetVisibility() },
            )
        }

        else -> Unit
    }
}
