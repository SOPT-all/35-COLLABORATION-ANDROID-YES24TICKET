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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import org.andsopt.android.yes24ticket.presentation.ui.home.component.AdDisplayedHorizontalPager
import org.andsopt.android.yes24ticket.presentation.ui.home.component.HeadDisplayedHorizontalPager
import org.andsopt.android.yes24ticket.presentation.ui.home.component.LiveTicketRankingLazyRow
import org.andsopt.android.yes24ticket.presentation.ui.home.component.SectionHeaderWithBlueArrow
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme
import org.andsopt.android.yes24ticket.util.compose.rightBorder
import org.andsopt.android.yes24ticket.util.compose.topBorder

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    value: String,
    onValueChange: (String) -> Unit,
    navigateToCategoryDetail: () -> Unit,
    headDisplayedPagerState: PagerState,
    adDisplayedPagerState: PagerState,
    mainBannerItemList: List<MainBannerEntity>,
    categoryList: List<String>,
    ticketRankingItemList: List<LiveTicketRankingEntity>,
    adBannerItemList: List<AdBannerEntity>,
    whatsHotItemList: List<WhatsHotEntity>,
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
            Modifier
                .fillMaxSize()
                .background(color = Yes24TicketTheme.colorScheme.gray100),
    ) {
        LazyColumn(
            state = lazyScrollState,
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
                HomeGridCategory(
                    categoryList = categoryList,
                    navigateToCategoryDetail = navigateToCategoryDetail,
                )
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
                Spacer(modifier = Modifier.height(20.dp))
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
    modifier: Modifier = Modifier,
    @StringRes placeholder: Int = R.string.home_top_bar_placeholder,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
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
    placeholder: String,
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit = { _ -> },
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
    navigateToCategoryDetail: () -> Unit,
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
                        .background(color = Yes24TicketTheme.colorScheme.white)
                        .topBorder(color = Yes24TicketTheme.colorScheme.gray150, height = 1f)
                        .rightBorder(color = Yes24TicketTheme.colorScheme.gray150, width = 1f),
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
                                    Modifier.clickable { navigateToCategoryDetail() }
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
                .padding(vertical = 12.dp)
                .border(width = 1.dp, color = Yes24TicketTheme.colorScheme.gray150),
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
                .border(width = 1.dp, color = Yes24TicketTheme.colorScheme.gray150),
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
            modifier = Modifier.padding(end = 8.dp),
        )
    }
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
                    .clip(RoundedCornerShape(topEnd = 3.dp, topStart = 3.dp)),
            contentScale = ContentScale.Crop,
        )

        Column(
            modifier
                .fillMaxWidth()
                .background(color = Yes24TicketTheme.colorScheme.white)
                .padding(horizontal = 9.dp, vertical = 7.dp),
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
                color = Yes24TicketTheme.colorScheme.gray800,
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = whatsHotItem.area,
                    style = Yes24TicketTheme.typography.bodyBold14,
                    color = Yes24TicketTheme.colorScheme.gray800,
                )

                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_divide_line_17),
                    contentDescription = stringResource(R.string.icon_divider_description),
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
private fun HomePreview() {
    HomeRoute({})
}
