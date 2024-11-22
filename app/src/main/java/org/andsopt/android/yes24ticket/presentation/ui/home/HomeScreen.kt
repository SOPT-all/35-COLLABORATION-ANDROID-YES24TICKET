package org.andsopt.android.yes24ticket.presentation.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.andsopt.android.yes24ticket.domain.model.MainBannerEntity
import org.andsopt.android.yes24ticket.presentation.ui.component.Yes24TopAppBar

@Composable
fun HomeRoute(modifier: Modifier = Modifier) {

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val headDisplayPagerState = rememberPagerState(initialPage = Int.MAX_VALUE / 2) {
        Int.MAX_VALUE
    }
    val dummyBannerItems = listOf(
        MainBannerEntity(
            id = "1",
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
            title = "뮤지컬 시지프스",
            area = "예스24스테이지 2관",
            date = "2024. 12 - 2025. 03"
        ),
        MainBannerEntity(
            id = "2",
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
            title = "오페라의 유령",
            area = "예스24스테이지 1관",
            date = "2024. 10 - 2024. 12"
        ),
        MainBannerEntity(
            id = "3",
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
            title = "레미제라블",
            area = "예스24스테이지 3관",
            date = "2025. 01 - 2025. 03"
        ),
        MainBannerEntity(
            id = "4",
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
            title = "햄릿",
            area = "예스24스테이지 4관",
            date = "2024. 11 - 2025. 02"
        ),
        MainBannerEntity(
            id = "5",
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
            title = "킹키부츠",
            area = "예스24스테이지 5관",
            date = "2024. 09 - 2024. 12"
        )
    )
    LazyColumn(modifier = modifier) {
        stickyHeader {
            Yes24TopAppBar()
        }

        item {
            HomeHeadDisplayedHorizontalPager(
                state = headDisplayPagerState,
                mainBannerList = dummyBannerItems,
            )
        }
    }
}

@Composable
fun HomeGridCategory(modifier: Modifier = Modifier) {
}