package org.andsopt.android.yes24ticket.presentation.ui.home

import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeRoute(
    navigateToCategoryDetail: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val text by remember { mutableStateOf("") }

    val headDisplayPagerState =
        rememberPagerState(initialPage = Int.MAX_VALUE / 2) {
            Int.MAX_VALUE
        }
    val adDisplayedPagerState =
        rememberPagerState(initialPage = Int.MAX_VALUE / 2) {
            Int.MAX_VALUE
        }

    HomeScreen(
        value = text,
        onValueChange = {},
        navigateToCategoryDetail = navigateToCategoryDetail,
        headDisplayedPagerState = headDisplayPagerState,
        adDisplayedPagerState = adDisplayedPagerState,
        mainBannerItemList = viewModel.dummyBannerItems,
        categoryList = viewModel.categoryList,
        ticketRankingItemList = viewModel.dummyRankingList,
        adBannerItemList = viewModel.dummyAdBannerList,
        whatsHotItemList = viewModel.dummyWhatsHotItems,
    )
}
