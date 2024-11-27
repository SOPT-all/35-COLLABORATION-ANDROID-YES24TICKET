package org.andsopt.android.yes24ticket.presentation.ui.category

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun CategoryDetailRoute(
    viewModel: CategoryDetailViewModel = hiltViewModel(),
    moveToBackStack: () -> Unit,
) {
    val bottomSheetState by viewModel.bottomSheetState.collectAsStateWithLifecycle()

    CategoryDetailScreen(
        categoryContentList = viewModel.mockContent,
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
