package org.andsopt.android.yes24ticket.presentation.ui.home

import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheonjaeung.compose.grid.SimpleGridCells
import com.cheonjaeung.compose.grid.VerticalGrid
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.domain.model.AdBannerEntity
import org.andsopt.android.yes24ticket.domain.model.LiveTicketRankingEntity
import org.andsopt.android.yes24ticket.domain.model.MainBannerEntity
import org.andsopt.android.yes24ticket.presentation.ui.component.Yes24TopAppBar
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme

@Composable
fun HomeRoute(modifier: Modifier = Modifier) {
    val headDisplayPagerState =
        rememberPagerState(initialPage = Int.MAX_VALUE / 2) {
            Int.MAX_VALUE
        }
    val adDisplayedPagerState =
        rememberPagerState(initialPage = Int.MAX_VALUE / 2) {
            Int.MAX_VALUE
        }
    val dummyBannerItems = listOf(
        MainBannerEntity(
            id = 1,
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
            title = "뮤지컬 시지프스",
            area = "예스24스테이지 2관",
            date = "2024. 12 - 2025. 03"
        ),
        MainBannerEntity(
            id = 2,
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
            title = "오페라의 유령",
            area = "예스24스테이지 1관",
            date = "2024. 10 - 2024. 12"
        ),
        MainBannerEntity(
            id = 3,
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
            title = "레미제라블",
            area = "예스24스테이지 3관",
            date = "2025. 01 - 2025. 03"
        ),
        MainBannerEntity(
            id = 4,
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
            title = "햄릿",
            area = "예스24스테이지 4관",
            date = "2024. 11 - 2025. 02"
        ),
        MainBannerEntity(
            id = 5,
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
            title = "킹키부츠",
            area = "예스24스테이지 5관",
            date = "2024. 09 - 2024. 12"
        )
    )

    val categoryList = listOf("콘서트", "뮤지컬", "연극", "클래식/무용", "전시/행사", "가족/어린이")

    val dummyRankingList = listOf(
        LiveTicketRankingEntity(
            id = 1,
            rank = 1,
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp"
        ),
        LiveTicketRankingEntity(
            id = 2,
            rank = 2,
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp"
        ),
        LiveTicketRankingEntity(
            id = 3,
            rank = 3,
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp"
        ),
        LiveTicketRankingEntity(
            id = 4,
            rank = 4,
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp"
        ),
        LiveTicketRankingEntity(
            id = 5,
            rank = 5,
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp"
        )
    )
    val dummyAdBannerList = listOf(
        AdBannerEntity(
            id = 1,
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp"
        ),
        AdBannerEntity(
            id = 2,
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp"
        ),
        AdBannerEntity(
            id = 3,
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp"
        ),
        AdBannerEntity(
            id = 4,
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp"
        ),
        AdBannerEntity(
            id = 5,
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp"
        )
    )

    HomeScreen(
        headDisplayedPagerState = headDisplayPagerState,
        adDisplayedPagerState = adDisplayedPagerState,
        mainBannerItemList = dummyBannerItems,
        categoryList = categoryList,
        ticketRankingItemList = dummyRankingList,
        adBannerItemList = dummyAdBannerList,
        modifier = modifier
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    headDisplayedPagerState: PagerState,
    adDisplayedPagerState: PagerState,
    mainBannerItemList: List<MainBannerEntity>,
    categoryList: List<String>,
    ticketRankingItemList: List<LiveTicketRankingEntity>,
    adBannerItemList: List<AdBannerEntity>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.background(color = Yes24TicketTheme.colorScheme.gray100),
    ) {
        stickyHeader {
            Yes24TopAppBar()
        }

        item {
            HeadDisplayedHorizontalPager(
                state = headDisplayedPagerState,
                mainBannerList = mainBannerItemList,
            )
        }

        item {
            HomeGridCategory(categoryList, {})
        }

        item {
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            LiveTicketRanking(
                text = R.string.home_section_head_ranking_list_text,
                ticketRankingItemList = ticketRankingItemList
            )
        }

        item {
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            TicketOpenAnnouncement()
        }

        item {
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            AdDisplayedHorizontalPager(
                state = adDisplayedPagerState,
                adBannerList = adBannerItemList
            )
        }
    }
}

@Composable
fun HomeGridCategory(
    categoryList: List<String>,
    naviagateToCategory: () -> Unit,
    modifier: Modifier = Modifier,
) {
    VerticalGrid(
        columns = SimpleGridCells.Fixed(3),
        modifier = modifier.fillMaxWidth(),
    ) {
        categoryList.forEachIndexed { idx, category ->
            Box(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(color = Yes24TicketTheme.colorScheme.white)
                    .border(width = 1.dp, color = Yes24TicketTheme.colorScheme.gray150),
            ) {
                Text(
                    text = category,
                    style = Yes24TicketTheme.typography.buttonBold14,
                    modifier =
                    Modifier
                        .align(Alignment.Center)
                        .padding(vertical = 12.dp)
                        .then(
                            if (idx == 0) {
                                Modifier.clickable { naviagateToCategory() }
                            } else {
                                Modifier
                            },
                        ),
                )
            }
        }
    }
}

@Composable
fun LiveTicketRanking(
    @StringRes text: Int,
    ticketRankingItemList: List<LiveTicketRankingEntity>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier =
        modifier
            .background(color = Yes24TicketTheme.colorScheme.white)
            .padding(vertical = 12.dp),
    ) {
        SectionHeaderWithBlueArrow(
            text = text,
            style = Yes24TicketTheme.typography.headBold15,
            modifier = Modifier.padding(bottom = 12.dp),
        )

        LiveTicketRankingLazyRow(
            ticketRankingList = ticketRankingItemList,
        )
    }
}

@Composable
fun TicketOpenAnnouncement(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Yes24TicketTheme.colorScheme.white)
            .padding(end = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 12.dp)
        ) {
            SectionHeaderWithBlueArrow(
                text = R.string.home_section_header_ticket_announcement_text,
                style = Yes24TicketTheme.typography.titleBold12
            )

            Spacer(modifier = Modifier.width(6.dp))

            VerticalDivider(
                modifier =
                Modifier
                    .height(11.dp),
                thickness = 1.dp,
                color = Yes24TicketTheme.colorScheme.gray200,
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = stringResource(R.string.home_ticket_annoucement_example_text),
                style = Yes24TicketTheme.typography.bodySemiBold12
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_down_16),
            contentDescription = stringResource(R.string.icon_arrow_down_16_description),
        )
    }
}

@Preview
@Composable
private fun CategoryPreview() {
    HomeGridCategory(listOf("콘서트", "뮤지컬", "콘서트", "뮤지컬", "콘서트", "뮤지컬"), {})
}

@Preview
@Composable
private fun TicketAnnouncementPreview() {
    TicketOpenAnnouncement()

}

@Preview
@Composable
private fun HomePreview() {
    HomeRoute()
}


