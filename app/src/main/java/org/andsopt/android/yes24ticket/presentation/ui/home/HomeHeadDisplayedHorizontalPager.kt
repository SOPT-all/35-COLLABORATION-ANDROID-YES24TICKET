package org.andsopt.android.yes24ticket.presentation.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import kotlinx.coroutines.delay
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.domain.model.MainBannerEntity
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme

@Composable
fun HomeHeadDisplayedHorizontalPager(
    state: PagerState,
    mainBannerList: List<MainBannerEntity>,
    modifier: Modifier = Modifier,
) {
    val totalPageNum = mainBannerList.size
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
        DisplayedBannerItem(
            bannerItem = mainBannerList[index % totalPageNum],
            totalPage = totalPageNum,
            currentPage = index % totalPageNum + 1,
        )
    }
}

@SuppressLint("LogNotTimber")
@Composable
fun DisplayedBannerItem(
    bannerItem: MainBannerEntity,
    totalPage: Int,
    currentPage: Int,
) {
    Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(20.dp),
    ) {
        AsyncImage(
            model =
                ImageRequest.Builder(context = LocalContext.current)
                    .data(bannerItem.imgUrl)
                    .crossfade(true)
                    .build(),
            contentDescription = stringResource(R.string.home_main_banner_item_image_description),
            modifier =
                Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.3f / 1f),
        )

        BannerPageIndicator(
            currentPage = currentPage,
            totalPage = totalPage,
            modifier = Modifier.align(Alignment.BottomEnd),
        )

        MainBannerTextInfo(
            title = bannerItem.title,
            area = bannerItem.area,
            date = bannerItem.date,
            modifier = Modifier.align(Alignment.BottomStart),
        )
    }
}

@Composable
fun MainBannerTextInfo(
    title: String,
    area: String,
    date: String,
    modifier: Modifier = Modifier,
) {
    val shadowModifier =
        Modifier.shadow(
            elevation = 4.dp,
            ambientColor = Color.Black.copy(alpha = 0.25f),
            spotColor = Color.Black.copy(alpha = 0.25f),
        )
    Column(modifier = modifier) {
        Text(
            text = title,
            style = Yes24TicketTheme.typography.headExtraBold24,
            color = Yes24TicketTheme.colorScheme.white,
            modifier = shadowModifier,
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = area,
            style = Yes24TicketTheme.typography.titleBold13,
            color = Yes24TicketTheme.colorScheme.yellow50,
            modifier = shadowModifier,
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = date,
            style = Yes24TicketTheme.typography.titleBold13,
            color = Yes24TicketTheme.colorScheme.white,
            modifier = shadowModifier,
        )
    }
}

@Preview
@Composable
private fun HeadDisplayedBannerPreview() {
    val dummyBannerItem =
        MainBannerEntity(
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1725362669902656119.webp",
            title = "뮤지컬 시지프스",
            area = "예스24스테이지 2관",
            date = "2024. 12 - 2025. 03",
        )
    DisplayedBannerItem(
        bannerItem = dummyBannerItem,
        totalPage = 5,
        currentPage = 1,
    )
}
