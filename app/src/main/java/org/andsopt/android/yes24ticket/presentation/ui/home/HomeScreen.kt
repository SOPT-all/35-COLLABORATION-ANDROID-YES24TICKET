package org.andsopt.android.yes24ticket.presentation.ui.home

import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(
    navigateToCategoryDetail: () -> Unit,
) {
    // TODO 콘서트 카테고리 클릭하면 넘어가는 로직으로 수정
    navigateToCategoryDetail()
}
