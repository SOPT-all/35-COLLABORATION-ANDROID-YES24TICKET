package org.andsopt.android.yes24ticket.presentation.ui.home

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.cheonjaeung.compose.grid.SimpleGridCells
import com.cheonjaeung.compose.grid.VerticalGrid
import kotlinx.coroutines.launch
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.domain.model.AdBannerEntity
import org.andsopt.android.yes24ticket.domain.model.LiveTicketRankingEntity
import org.andsopt.android.yes24ticket.domain.model.MainBannerEntity
import org.andsopt.android.yes24ticket.domain.model.WhatsHotEntity
import org.andsopt.android.yes24ticket.presentation.ui.component.InformationFooter
import org.andsopt.android.yes24ticket.presentation.ui.component.ScrollToTopFloatingButton
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme

@Composable
fun HomeRoute(modifier: Modifier = Modifier) {
    val text by remember { mutableStateOf("") }

    val headDisplayPagerState =
        rememberPagerState(initialPage = Int.MAX_VALUE / 2) {
            Int.MAX_VALUE
        }
    val adDisplayedPagerState =
        rememberPagerState(initialPage = Int.MAX_VALUE / 2) {
            Int.MAX_VALUE
        }
    val dummyBannerItems =
        listOf(
            MainBannerEntity(
                id = 1,
                imgUrl = "http://tkfile.yes24.com/Upload2/Display/202411/20241122/wel_mv_youthculture.jpg/dims/quality/70/",
                title = "뮤지컬 시지프스",
                area = "예스24스테이지 2관",
                date = "2024. 12 - 2025. 03",
            ),
            MainBannerEntity(
                id = 2,
                imgUrl = "http://tkfile.yes24.com/Upload2/Display/202409/20240910/wel_mv_50929.jpg/dims/quality/70/",
                title = "오페라의 유령",
                area = "예스24스테이지 1관",
                date = "2024. 10 - 2024. 12",
            ),
            MainBannerEntity(
                id = 3,
                imgUrl = "http://tkfile.yes24.com/Upload2/Display/202411/20241115/wel_mv_51725_e6e6e4.png/dims/quality/70/",
                title = "레미제라블",
                area = "예스24스테이지 3관",
                date = "2025. 01 - 2025. 03",
            ),
            MainBannerEntity(
                id = 4,
                imgUrl = "http://tkfile.yes24.com/Upload2/Display/202410/20241014/wel_mv_51251.png/dims/quality/70/",
                title = "햄릿",
                area = "예스24스테이지 4관",
                date = "2024. 11 - 2025. 02",
            ),
            MainBannerEntity(
                id = 5,
                imgUrl = "http://tkfile.yes24.com/Upload2/Display/202411/20241115/wel_mv_51615_2_1.png/dims/quality/70/",
                title = "킹키부츠",
                area = "예스24스테이지 5관",
                date = "2024. 09 - 2024. 12",
            ),
        )

    val categoryList = listOf("콘서트", "뮤지컬", "연극", "클래식/무용", "전시/행사", "가족/어린이")

    val dummyRankingList =
        listOf(
            LiveTicketRankingEntity(
                id = 1,
                rank = 1,
                imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202410/20241029/20241029-51466.jpg/dims/quality/70/",
            ),
            LiveTicketRankingEntity(
                id = 2,
                rank = 2,
                imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202409/20240905/20240905-50929.jpg/dims/quality/70/",
            ),
            LiveTicketRankingEntity(
                id = 3,
                rank = 3,
                imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202411/20241118/20241118-50610.jpg/dims/quality/70/",
            ),
            LiveTicketRankingEntity(
                id = 4,
                rank = 4,
                imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202410/20241024/20241024-51251.jpg",
            ),
            LiveTicketRankingEntity(
                id = 5,
                rank = 5,
                imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202411/20241120/20241120-51786.jpg",
            ),
        )

    val dummyAdBannerList =
        listOf(
            AdBannerEntity(
                id = 1,
                imgUrl = "http://tkfile.yes24.com/Upload2/Display/202410/20241021/wel_wide_51324.png/dims/quality/70/",
            ),
            AdBannerEntity(
                id = 2,
                imgUrl = "http://tkfile.yes24.com/Upload2/Display/202411/20241115/wel_wide_51618_0a112c.png/dims/quality/70/",
            ),
            AdBannerEntity(
                id = 3,
                imgUrl = "http://tkfile.yes24.com/Upload2/Display/202410/20241021/wel_wide_51251_2.png/dims/quality/70/",
            ),
            AdBannerEntity(
                id = 4,
                imgUrl = "http://tkfile.yes24.com/Upload2/Display/202410/20241011/wel_wide_51249.png/dims/quality/70/",
            ),
            AdBannerEntity(
                id = 5,
                imgUrl = "http://tkfile.yes24.com/Upload2/Display/202411/20241122/wel_wide_51753.png/dims/quality/70/",
            ),
        )

    val dummyWhatsHotItems =
        listOf(
            WhatsHotEntity(
                id = 1,
                imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202411/20241101/20241101-51565.jpg/dims/quality/70/",
                title = "뮤지컬 시지프스",
                area = "예스24스테이지 2관",
                date = "2024. 12 - 2025. 03",
                comment = "안녕",
            ),
            WhatsHotEntity(
                id = 2,
                imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202411/20241120/20241120-51791.jpg/dims/quality/70/",
                title = "오페라의 유령",
                area = "예스24스테이지 1관",
                date = "2024. 10 - 2024. 12",
                comment = "안녕",
            ),
            WhatsHotEntity(
                id = 3,
                imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202411/20241113/20241113-51709.jpg/dims/quality/70/",
                title = "레미제라블",
                area = "예스24스테이지 3관",
                date = "2025. 01 - 2025. 03",
            ),
            WhatsHotEntity(
                id = 4,
                imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202410/20241014/20241014-51331_1.jpg/dims/quality/70/",
                title = "햄릿",
                area = "예스24스테이지 4관",
                date = "2024. 11 - 2025. 02",
            ),
            WhatsHotEntity(
                id = 5,
                imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202411/20241107/20241107-51641.jpg/dims/quality/70/",
                title = "킹키부츠",
                area = "예스24스테이지 5관",
                date = "2024. 09 - 2024. 12",
            ),
        )

    HomeScreen(
        value = text,
        onValueChange = {},
        headDisplayedPagerState = headDisplayPagerState,
        adDisplayedPagerState = adDisplayedPagerState,
        mainBannerItemList = dummyBannerItems,
        categoryList = categoryList,
        ticketRankingItemList = dummyRankingList,
        adBannerItemList = dummyAdBannerList,
        whatsHotItemList = dummyWhatsHotItems,
        modifier = modifier,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    value: String,
    onValueChange: (String) -> Unit,
    headDisplayedPagerState: PagerState,
    adDisplayedPagerState: PagerState,
    mainBannerItemList: List<MainBannerEntity>,
    categoryList: List<String>,
    ticketRankingItemList: List<LiveTicketRankingEntity>,
    adBannerItemList: List<AdBannerEntity>,
    whatsHotItemList: List<WhatsHotEntity>,
    modifier: Modifier = Modifier,
) {
    val lazyScrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val showButton by remember {
        derivedStateOf {
            lazyScrollState.firstVisibleItemScrollOffset > 0
        }
    }

    Box(
        modifier =
            modifier
                .fillMaxSize()
                .background(color = Yes24TicketTheme.colorScheme.gray100),
    ) {
        LazyColumn(
            state = lazyScrollState,
            modifier = modifier.background(color = Yes24TicketTheme.colorScheme.gray100),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            stickyHeader {
                HomeYes24TopAppBar(
                    value = value,
                    onValueChange = onValueChange,
                )
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
                    ticketRankingItemList = ticketRankingItemList,
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
                    adBannerList = adBannerItemList,
                )
            }

            item {
                WhatsHotText(
                    text = R.string.home_whats_hot,
                )
            }

            items(
                items = whatsHotItemList,
                key = { item -> item.id },
                contentType = { item -> item.title },
            ) { hotItem ->
                HotContentItem(
                    whatsHotItem = hotItem,
                )
            }

            item {
                InformationFooter()
            }
        }
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp, bottom = 10.dp)
                    .align(Alignment.BottomEnd),
            horizontalArrangement = Arrangement.End,
        ) {
            AnimatedVisibility(
                visible = showButton,
                enter = fadeIn(),
                exit = fadeOut(),
            ) {
                ScrollToTopFloatingButton(
                    onClick = {
                        coroutineScope.launch {
                            lazyScrollState.animateScrollToItem(0)
                        }
                    },
                )
            }
        }
    }
}

@Composable
fun HomeYes24TopAppBar(
    value: String = "",
    onValueChange: (String) -> Unit,
    @StringRes placeholder: Int = R.string.home_top_bar_placeholder,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Yes24TicketTheme.colorScheme.black),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(R.drawable.img_logo_yes24_84_37),
            contentDescription = stringResource(R.string.top_app_bar_logo_description),
            modifier = Modifier.padding(horizontal = 16.dp),
        )

        TopAppBarTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = stringResource(placeholder),
        )
    }
}

@Composable
fun TopAppBarTextField(
    value: String = "",
    onValueChange: (String) -> Unit = { _ -> },
    placeholder: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .padding(vertical = 13.dp)
                .padding(end = 8.dp)
                .wrapContentSize()
                .background(
                    color = Yes24TicketTheme.colorScheme.gray800,
                    shape = RoundedCornerShape(16.dp),
                )
                .padding(horizontal = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BasicTextField(
            modifier =
                Modifier
                    .padding(vertical = 10.dp)
                    .weight(1f),
            value = value,
            onValueChange = onValueChange,
            cursorBrush = SolidColor(Yes24TicketTheme.colorScheme.gray300),
            singleLine = true,
            decorationBox = { innerTextField: @Composable () -> Unit ->
                innerTextField()
                if (value.isEmpty()) {
                    Text(
                        text = placeholder,
                        color = Yes24TicketTheme.colorScheme.gray300,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            },
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_home_search_36),
            contentDescription = stringResource(R.string.home_icon_search_description),
            tint = Color.Unspecified,
        )
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
    modifier: Modifier = Modifier,
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
        modifier =
            modifier
                .fillMaxWidth()
                .background(color = Yes24TicketTheme.colorScheme.white)
                .padding(end = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier =
                Modifier
                    .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SectionHeaderWithBlueArrow(
                text = R.string.home_section_header_ticket_announcement_text,
                style = Yes24TicketTheme.typography.titleBold12,
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
                style = Yes24TicketTheme.typography.bodySemiBold12,
                color = Yes24TicketTheme.colorScheme.gray500,
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

@Composable
fun WhatsHotText(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        text = stringResource(text),
        style = Yes24TicketTheme.typography.headExtraBold20,
        modifier =
            modifier
                .fillMaxWidth()
                .padding(top = 36.dp, bottom = 24.dp),
        textAlign = TextAlign.Center,
    )
}

@Composable
fun HotContentItem(
    whatsHotItem: WhatsHotEntity,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .padding(horizontal = 5.dp)
                .padding(bottom = 12.dp),
    ) {
        AsyncImage(
            model =
                ImageRequest.Builder(context = LocalContext.current)
                    .data(whatsHotItem.imgUrl)
                    .crossfade(true)
                    .build(),
            contentDescription = stringResource(R.string.home_hot_content_image_description),
            modifier =
                Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f / 0.45f)
                    .clip(RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp)),
            contentScale = ContentScale.FillBounds,
        )

        Column(
            modifier
                .fillMaxWidth()
                .background(color = Yes24TicketTheme.colorScheme.white)
                .padding(horizontal = 10.dp, vertical = 7.dp),
        ) {
            if (!whatsHotItem.comment.isNullOrEmpty()) {
                Text(
                    text = whatsHotItem.comment,
                    style = Yes24TicketTheme.typography.bodySemiBold12,
                    color = Yes24TicketTheme.colorScheme.gray400,
                )
                Spacer(modifier = Modifier.height(6.dp))
            }

            Text(
                text = whatsHotItem.title,
                style = Yes24TicketTheme.typography.titleExtraBold17,
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = whatsHotItem.area,
                    style = Yes24TicketTheme.typography.bodyBold14,
                )

                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_divide_line_17),
                    contentDescription = stringResource(R.string.icon_divider_desription),
                    tint = Color.Unspecified,
                )

                Text(
                    text = whatsHotItem.date,
                    style = Yes24TicketTheme.typography.bodyBold13,
                    color = Yes24TicketTheme.colorScheme.gray400,
                )
            }
        }
    }
}

@Preview
@Composable
private fun TopAppBarTextFieldPreview() {
    var text by remember { mutableStateOf("") }

    HomeYes24TopAppBar(
        value = text,
        onValueChange = { newText -> text = newText },
        placeholder = R.string.home_top_bar_placeholder,
    )
}

@Preview
@Composable
private fun HomePreview() {
    HomeRoute()
}
