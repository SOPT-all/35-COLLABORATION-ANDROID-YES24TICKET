package org.andsopt.android.yes24ticket.presentation.ui.home

import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.delay

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

    LaunchedEffect(Unit) {
        while (true) {
            delay(4000)
            if (!headDisplayPagerState.isScrollInProgress) {
                if (viewModel.dummyBannerItems.isNotEmpty()) {
                    val nextPage = (headDisplayPagerState.currentPage + 1) % viewModel.dummyBannerItems.size
                    headDisplayPagerState.animateScrollToPage(nextPage)
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(4000)
            if (!adDisplayedPagerState.isScrollInProgress) {
                if (viewModel.dummyAdBannerList.isNotEmpty()) {
                    val nextPage = (adDisplayedPagerState.currentPage + 1) % viewModel.dummyAdBannerList.size
                    adDisplayedPagerState.animateScrollToPage(nextPage)
                }
            }
        }
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
