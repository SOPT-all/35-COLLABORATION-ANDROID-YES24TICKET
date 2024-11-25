package org.andsopt.android.yes24ticket.presentation.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import kotlinx.coroutines.delay
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.domain.model.AdBannerEntity

@Composable
fun AdDisplayedHorizontalPager(
    state: PagerState,
    adBannerList: List<AdBannerEntity>,
    modifier: Modifier = Modifier,
) {
    val totalPageNum = adBannerList.size

    LaunchedEffect(Unit) {
        while (true) {
            delay(4000)
            if (!state.isScrollInProgress) {
                if (totalPageNum > 0) {
                    val nextPage = (state.currentPage + 1) % totalPageNum
                    state.animateScrollToPage(nextPage)
                }
            }
        }
    }

    HorizontalPager(
        modifier =
        modifier
            .fillMaxWidth(),
        state = state,
    ) { index ->
        AdDisplayedBannerItem(
            bannerItem = adBannerList[index % totalPageNum],
            totalPage = totalPageNum,
            currentPage = index % totalPageNum + 1,
        )
    }
}

@Composable
fun AdDisplayedBannerItem(
    bannerItem: AdBannerEntity,
    totalPage: Int,
    currentPage: Int,
) {
    Box(
        modifier =
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
    ) {
        AsyncImage(
            model =
            ImageRequest.Builder(context = LocalContext.current)
                .data(bannerItem.imgUrl)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.home_ad_banner_item_image_description),
            modifier =
            Modifier
                .fillMaxWidth()
                .aspectRatio(2.4f / 1f),
        )

        BannerPageIndicator(
            currentPage = currentPage,
            totalPage = totalPage,
            modifier = Modifier.align(Alignment.BottomEnd),
        )
    }
}
