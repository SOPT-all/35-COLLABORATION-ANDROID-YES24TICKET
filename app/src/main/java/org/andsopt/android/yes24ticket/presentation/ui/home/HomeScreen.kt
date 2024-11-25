package org.andsopt.android.yes24ticket.presentation.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheonjaeung.compose.grid.SimpleGridCells
import com.cheonjaeung.compose.grid.VerticalGrid
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
    val dummyBannerItems =
        listOf(
            MainBannerEntity(
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
                title = "뮤지컬 시지프스",
                area = "예스24스테이지 2관",
                date = "2024. 12 - 2025. 03",
            ),
            MainBannerEntity(
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
                title = "오페라의 유령",
                area = "예스24스테이지 1관",
                date = "2024. 10 - 2024. 12",
            ),
            MainBannerEntity(
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
                title = "레미제라블",
                area = "예스24스테이지 3관",
                date = "2025. 01 - 2025. 03",
            ),
            MainBannerEntity(
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
                title = "햄릿",
                area = "예스24스테이지 4관",
                date = "2024. 11 - 2025. 02",
            ),
            MainBannerEntity(
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
                title = "킹키부츠",
                area = "예스24스테이지 5관",
                date = "2024. 09 - 2024. 12",
            ),
        )

    val categoryList = listOf("콘서트", "뮤지컬", "연극", "클래식/무용", "전시/행사", "가족/어린이")

    val dummyRankingList =
        listOf(
            LiveTicketRankingEntity(
                rank = 1,
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
            ),
            LiveTicketRankingEntity(
                rank = 2,
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
            ),
            LiveTicketRankingEntity(
                rank = 3,
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
            ),
            LiveTicketRankingEntity(
                rank = 4,
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
            ),
            LiveTicketRankingEntity(
                rank = 5,
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
            ),
        )

    HomeScreen(
        pagerState = headDisplayPagerState,
        mainBannerItemList = dummyBannerItems,
        categoryList = categoryList,
        ticketRankingItemList = dummyRankingList,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    pagerState: PagerState,
    mainBannerItemList: List<MainBannerEntity>,
    categoryList: List<String>,
    ticketRankingItemList: List<LiveTicketRankingEntity>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.background(color = Yes24TicketTheme.colorScheme.gray100),
    ) {
        stickyHeader {
            Yes24TopAppBar()
        }

        item {
            HomeHeadDisplayedHorizontalPager(
                state = pagerState,
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
            Column(
                modifier =
                    Modifier
                        .background(color = Yes24TicketTheme.colorScheme.white)
                        .padding(vertical = 12.dp),
            ) {
                SectionHeaderWithBlueArrow(
                    text = "실시간 티켓 랭킹",
                    style = Yes24TicketTheme.typography.headBold15,
                    modifier = Modifier.padding(bottom = 12.dp),
                )

                LiveTicketRankingLazyRow(
                    ticketRankingList = ticketRankingItemList,
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(8.dp))
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

@Preview
@Composable
private fun CategoryPreview() {
    HomeGridCategory(listOf("콘서트", "뮤지컬", "콘서트", "뮤지컬", "콘서트", "뮤지컬"), {})
}
