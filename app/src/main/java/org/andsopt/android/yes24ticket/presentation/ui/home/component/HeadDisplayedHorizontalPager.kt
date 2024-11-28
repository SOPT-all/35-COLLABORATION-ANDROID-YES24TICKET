package org.andsopt.android.yes24ticket.presentation.ui.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import kotlinx.coroutines.delay
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.domain.model.MainBannerEntity
import org.andsopt.android.yes24ticket.domain.model.MainBannerItem
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme

@Composable
fun HeadDisplayedHorizontalPager(
    state: PagerState,
    mainBannerList: MainBannerEntity,
    modifier: Modifier = Modifier,
) {
    val totalPageNum = mainBannerList.bannerLists.size
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
        HeadDisplayedBannerItem(
            bannerItem = mainBannerList.bannerLists[index % totalPageNum],
            totalPage = totalPageNum,
            currentPage = index % totalPageNum + 1,
        )
    }
}

@Composable
fun HeadDisplayedBannerItem(
    bannerItem: MainBannerItem,
    totalPage: Int,
    currentPage: Int,
) {
    Box(
        modifier =
            Modifier
                .fillMaxWidth(),
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
            contentScale = ContentScale.Crop,
        )

        BannerPageIndicator(
            currentPage = currentPage,
            totalPage = totalPage,
            modifier =
                Modifier
                    .align(Alignment.BottomEnd)
                    .padding(20.dp),
        )

        if (!bannerItem.title.isNullOrEmpty() &&
            !bannerItem.area.isNullOrEmpty() &&
            !bannerItem.date.isNullOrEmpty()
        ) {
            MainBannerTextInfo(
                title = bannerItem.title,
                area = bannerItem.area,
                date = bannerItem.date,
                modifier =
                    Modifier
                        .align(Alignment.BottomStart)
                        .padding(20.dp),
            )
        }
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
