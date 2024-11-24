package org.andsopt.android.yes24ticket.presentation.ui.category

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.andsopt.android.yes24ticket.domain.model.CategoryContentEntity
import org.andsopt.android.yes24ticket.presentation.type.FilterType
import org.andsopt.android.yes24ticket.presentation.ui.category.state.CategoryDetailBottomSheetState
import javax.inject.Inject

@HiltViewModel
class CategoryDetailViewModel
@Inject
constructor() : ViewModel() {
    private val _bottomSheetState = MutableStateFlow(CategoryDetailBottomSheetState())
    val bottomSheetState: StateFlow<CategoryDetailBottomSheetState>
        get() = _bottomSheetState.asStateFlow()

    fun setFilterType(selectedFilterType: FilterType?) {
        _bottomSheetState.value = _bottomSheetState.value.copy(selectedFilterType = selectedFilterType)
    }

    fun changeBottomSheetVisibility() {
        _bottomSheetState.value = _bottomSheetState.value.copy(isBottomSheetVisible = !_bottomSheetState.value.isBottomSheetVisible)
    }

    val mockContent = listOf(
        CategoryContentEntity(
            contentId = 1,
            contentImg = "https://tkfile.yes24.com/upload2/perfblog/202411/20241119/20241119-51767.jpg/dims/quality/70/",
            contentTitle = "플라워 25주년 콘서트",
            contentPlace = "건국대학교 새천년관",
            contentPeriod = "2024. 12. 01 - 01. 15"
        ),
        CategoryContentEntity(
            contentId = 2,
            contentImg = "http://tkfile.yes24.com/upload2/perfblog/202411/20241108/20241108-51651.jpg/dims/quality/70/",
            contentTitle = "플라워 25주년 콘서트 플라워 25주년 콘서트 플라워 25주년 콘서트",
            contentPlace = "건국대학교 새천년관",
            contentPeriod = "2024. 12. 01 - 01. 15"
        ),
        CategoryContentEntity(
            contentId = 3,
            contentImg = "http://tkfile.yes24.com/upload2/perfblog/202408/20240813/20240813-50694.jpg/dims/quality/70/",
            contentTitle = "플라워 25주년 콘서트",
            contentPlace = "건국대학교 새천년관",
            contentPeriod = "2024. 12. 01 - 01. 15"
        ),
        CategoryContentEntity(
            contentId = 4,
            contentImg = "http://tkfile.yes24.com/upload2/perfblog/202411/20241114/20241114-51722.jpg/dims/quality/70/",
            contentTitle = "플라워 25주년 콘서트 플라워 25주년 콘서트 플라워 25주년 콘서트",
            contentPlace = "건국대학교 새천년관",
            contentPeriod = "2024. 12. 01 - 01. 15"
        ),
        CategoryContentEntity(
            contentId = 1,
            contentImg = "https://tkfile.yes24.com/upload2/perfblog/202411/20241119/20241119-51767.jpg/dims/quality/70/",
            contentTitle = "플라워 25주년 콘서트",
            contentPlace = "건국대학교 새천년관",
            contentPeriod = "2024. 12. 01 - 01. 15"
        ),
        CategoryContentEntity(
            contentId = 2,
            contentImg = "http://tkfile.yes24.com/upload2/perfblog/202411/20241108/20241108-51651.jpg/dims/quality/70/",
            contentTitle = "플라워 25주년 콘서트",
            contentPlace = "건국대학교 새천년관",
            contentPeriod = "2024. 12. 01 - 01. 15"
        ),
        CategoryContentEntity(
            contentId = 3,
            contentImg = "http://tkfile.yes24.com/upload2/perfblog/202408/20240813/20240813-50694.jpg/dims/quality/70/",
            contentTitle = "플라워 25주년 콘서트",
            contentPlace = "건국대학교 새천년관",
            contentPeriod = "2024. 12. 01 - 01. 15"
        ),
        CategoryContentEntity(
            contentId = 4,
            contentImg = "http://tkfile.yes24.com/upload2/perfblog/202411/20241114/20241114-51722.jpg/dims/quality/70/",
            contentTitle = "플라워 25주년 콘서트",
            contentPlace = "건국대학교 새천년관",
            contentPeriod = "2024. 12. 01 - 01. 15"
        ),
        CategoryContentEntity(
            contentId = 1,
            contentImg = "https://tkfile.yes24.com/upload2/perfblog/202411/20241119/20241119-51767.jpg/dims/quality/70/",
            contentTitle = "플라워 25주년 콘서트",
            contentPlace = "건국대학교 새천년관",
            contentPeriod = "2024. 12. 01 - 01. 15"
        ),
    )
}
