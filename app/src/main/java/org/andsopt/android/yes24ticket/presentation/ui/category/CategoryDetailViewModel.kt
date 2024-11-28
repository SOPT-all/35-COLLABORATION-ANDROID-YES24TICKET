package org.andsopt.android.yes24ticket.presentation.ui.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.andsopt.android.yes24ticket.domain.repository.CategoryRepository
import org.andsopt.android.yes24ticket.presentation.type.FilterType
import org.andsopt.android.yes24ticket.presentation.ui.category.state.CategoryDetailBottomSheetState
import org.andsopt.android.yes24ticket.presentation.ui.category.state.CategoryDetailState
import org.andsopt.android.yes24ticket.presentation.ui.category.state.CategoryDetailUiState
import javax.inject.Inject

@HiltViewModel
class CategoryDetailViewModel
    @Inject
    constructor(
        private val categoryRepository: CategoryRepository,
    ) : ViewModel() {
        private val _bottomSheetState = MutableStateFlow(CategoryDetailBottomSheetState())
        val bottomSheetState: StateFlow<CategoryDetailBottomSheetState>
            get() = _bottomSheetState.asStateFlow()

        private val _categoryDetailState = MutableStateFlow(CategoryDetailState())
        val categoryDetailState: StateFlow<CategoryDetailState>
            get() = _categoryDetailState.asStateFlow()

        val categoryDetailUiState: StateFlow<CategoryDetailUiState> =
            flow<CategoryDetailUiState> {
                runCatching {
                    categoryRepository.getCategoryDetailList(sortBy = _bottomSheetState.value.selectedFilterType?.id)
                }.onSuccess { contentList ->
                    _categoryDetailState.value = _categoryDetailState.value.copy(categoryDetailList = contentList)
                    emit(CategoryDetailUiState.Success(contentList))
                }.onFailure { throwable ->
                    emit(CategoryDetailUiState.Error(throwable.message))
                }
            }.catch { throwable ->
                emit(CategoryDetailUiState.Error(throwable.message))
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = CategoryDetailUiState.Loading,
            )

        fun setFilterType(selectedFilterType: FilterType?) {
            _bottomSheetState.value = _bottomSheetState.value.copy(selectedFilterType = selectedFilterType)
            fetchCategoryDetails()
        }

        fun changeBottomSheetVisibility() {
            _bottomSheetState.value = _bottomSheetState.value.copy(isBottomSheetVisible = !_bottomSheetState.value.isBottomSheetVisible)
        }

        private fun fetchCategoryDetails() {
            viewModelScope.launch {
                runCatching {
                    categoryRepository.getCategoryDetailList(sortBy = _bottomSheetState.value.selectedFilterType?.id)
                }.onSuccess { categoryContent ->
                    _categoryDetailState.value = _categoryDetailState.value.copy(categoryDetailList = categoryContent)
                }
            }
        }
    }
