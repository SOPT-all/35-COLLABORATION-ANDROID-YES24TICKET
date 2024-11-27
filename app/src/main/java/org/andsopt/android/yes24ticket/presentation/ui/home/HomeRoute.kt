package org.andsopt.android.yes24ticket.presentation.ui.home

import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.delay
import org.andsopt.android.yes24ticket.presentation.type.HomeCategoryType
import org.andsopt.android.yes24ticket.presentation.ui.home.state.HomeUiState

@Composable
fun HomeRoute(
    navigateToCategoryDetail: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val homeUiState by viewModel.homeUiState.collectAsStateWithLifecycle()
    val text by remember { mutableStateOf("") }

    when (homeUiState) {
        is HomeUiState.Success -> {
            val headDisplayPagerState =
                rememberPagerState(initialPage = Int.MAX_VALUE / 2) {
                    Int.MAX_VALUE
                }
            val adDisplayedPagerState =
                rememberPagerState(initialPage = Int.MAX_VALUE / 2) {
                    Int.MAX_VALUE
                }

            val mainBannerList = (homeUiState as HomeUiState.Success).mainBannerItemList
            val adBannerList = (homeUiState as HomeUiState.Success).adBannerItemList
            val ticketRankingList = (homeUiState as HomeUiState.Success).ticketRankingItemList
            val whatsHotList = (homeUiState as HomeUiState.Success).whatsHotItemList

            LaunchedEffect(Unit) {
                while (true) {
                    delay(4000)
                    if (!headDisplayPagerState.isScrollInProgress) {
                        if (mainBannerList.bannerLists.isNotEmpty()) {
                            val nextPage = (headDisplayPagerState.currentPage + 1) % mainBannerList.bannerLists.size
                            headDisplayPagerState.animateScrollToPage(nextPage)
                        }
                    }
                }
            }

            LaunchedEffect(Unit) {
                while (true) {
                    delay(4000)
                    if (!adDisplayedPagerState.isScrollInProgress) {
                        if (adBannerList.bannerLists.isNotEmpty()) {
                            val nextPage = (adDisplayedPagerState.currentPage + 1) % adBannerList.bannerLists.size
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
                mainBannerItemList = mainBannerList,
                categoryList = HomeCategoryType.entries,
                ticketRankingItemList = ticketRankingList,
                adBannerItemList = adBannerList,
                whatsHotItemList = whatsHotList,
            )
        }

        is HomeUiState.Loading -> Unit
        is HomeUiState.Error -> Unit
    }
}
