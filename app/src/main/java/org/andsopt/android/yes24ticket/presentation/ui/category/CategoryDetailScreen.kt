package org.andsopt.android.yes24ticket.presentation.ui.category

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.domain.model.CategoryContentEntity
import org.andsopt.android.yes24ticket.presentation.type.FilterType
import org.andsopt.android.yes24ticket.presentation.ui.component.InformationFooter
import org.andsopt.android.yes24ticket.presentation.ui.component.ScrollToTopFloatingButton
import org.andsopt.android.yes24ticket.presentation.ui.component.Yes24TopAppBar
import org.andsopt.android.yes24ticket.ui.theme.YES24TICKETTheme
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme
import org.andsopt.android.yes24ticket.util.compose.bottomBorder
import org.andsopt.android.yes24ticket.util.compose.leftBorder
import org.andsopt.android.yes24ticket.util.compose.noRippleClickable
import org.andsopt.android.yes24ticket.util.compose.topBorder

@Composable
fun CategoryDetailScreen(
    categoryContentList: List<CategoryContentEntity>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight(Alignment.CenterVertically)
    ) {
        Yes24TopAppBar()

        CategoryTitleRow()

        Spacer(Modifier.height(10.dp))

        CategoryTabRow()

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            CategoryContentLazyVerticalGrid(
                categoryContentList = categoryContentList,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp, top = 10.dp),
                horizontalArrangement = Arrangement.End,
            ) {
                FilterSelector(
                    onClickFilterSelector = {}
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp, bottom = 10.dp)
                    .align(Alignment.BottomEnd),
                horizontalArrangement = Arrangement.End,
            ) {
                ScrollToTopFloatingButton(
                    onClick = {}
                )
            }
        }
    }
}

@Composable
private fun CategoryTitleRow() {
    Text(
        text = stringResource(R.string.category_detail_title_concert),
        modifier = Modifier
            .fillMaxWidth()
            .background(Yes24TicketTheme.colorScheme.gray50)
            .padding(vertical = 10.dp),
        color = Yes24TicketTheme.colorScheme.gray700,
        textAlign = TextAlign.Center,
        style = Yes24TicketTheme.typography.headBold15
    )

    HorizontalDivider(
        thickness = 1.dp,
        color = Yes24TicketTheme.colorScheme.gray200
    )
}

@Composable
private fun CategoryTabRow() {
    Row(
        modifier =
            Modifier.fillMaxWidth()
    ) {
        TabWithTopBorder(
            tabTitleText = R.string.category_detail_sub_title_recommend_concert,
            modifier = Modifier.weight(1f)
        )

        TabWithTopStartBottomBorder(
            tabTitleText = R.string.category_detail_sub_title_ranking,
            modifier = Modifier.weight(1f)
        )

        TabWithTopStartBottomBorder(
            tabTitleText = R.string.category_detail_sub_title_list,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun TabWithTopBorder(
    @StringRes tabTitleText: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(tabTitleText),
        modifier = modifier
            .topBorder(color = Yes24TicketTheme.colorScheme.gray200, height = 1f)
            .padding(vertical = 10.dp),
        color = Yes24TicketTheme.colorScheme.gray900,
        textAlign = TextAlign.Center,
        style = Yes24TicketTheme.typography.buttonBold13
    )
}

@Composable
private fun TabWithTopStartBottomBorder(
    @StringRes tabTitleText: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(tabTitleText),
        modifier = modifier
            .leftBorder(color = Yes24TicketTheme.colorScheme.gray200, width = 1f)
            .topBorder(color = Yes24TicketTheme.colorScheme.gray200, height = 1f)
            .bottomBorder(color = Yes24TicketTheme.colorScheme.gray200, height = 1f)
            .background(Yes24TicketTheme.colorScheme.gray100)
            .padding(vertical = 10.dp),
        color = Yes24TicketTheme.colorScheme.gray700,
        textAlign = TextAlign.Center,
        style = Yes24TicketTheme.typography.buttonRegular13
    )
}

@Composable
private fun FilterSelector(
    onClickFilterSelector: () -> Unit,
    modifier: Modifier = Modifier,
    filterText: String = stringResource(R.string.category_detail_filter),
    isSelected: Boolean = false,
    selectedType: FilterType = FilterType.POPULAR,
) {
    Row(
        modifier = modifier
            .background(
                color = if (!isSelected) Yes24TicketTheme.colorScheme.gray50 else Yes24TicketTheme.colorScheme.red50
            )
            .border(
                width = 1.dp,
                color = if (!isSelected) Yes24TicketTheme.colorScheme.gray150 else Yes24TicketTheme.colorScheme.red100,
                shape = RoundedCornerShape(2.dp)
            )
            .noRippleClickable { onClickFilterSelector() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = if (!isSelected) filterText else stringResource(selectedType.filter),
            modifier = Modifier
                .padding(start = 6.dp),
            style = Yes24TicketTheme.typography.captionRegular11,
            color = if (!isSelected) Yes24TicketTheme.colorScheme.gray400 else Yes24TicketTheme.colorScheme.red100,
        )

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_category_array_deselected_18),
            contentDescription = stringResource(R.string.category_detail_filter_description),
            tint = if (!isSelected) Yes24TicketTheme.colorScheme.gray400 else Yes24TicketTheme.colorScheme.red100,
            modifier = Modifier.padding(top = 3.dp, bottom = 3.dp, end = 2.dp)
        )
    }
}

@Composable
private fun CategoryContentLazyVerticalGrid(
    categoryContentList: List<CategoryContentEntity>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(GRID_CELLS_DEFAULT),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        contentPadding = PaddingValues(top = 44.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        itemsIndexed(
            categoryContentList,
            key = { index, _ -> index },
            contentType = { _, item -> item },
        ) { _, item ->
            CategoryContentCard(
                contentImg = item.contentImg,
                contentTitle = item.contentTitle,
                contentPlace = item.contentPlace,
                contentPeriod = item.contentPeriod,
                imageWidth = (LocalConfiguration.current.screenWidthDp.dp) / 2
            )
        }

        item(span = { GridItemSpan(GRID_CELLS_DEFAULT) }) {
            Spacer(Modifier.height(56.dp))
        }

        item(span = { GridItemSpan(GRID_CELLS_DEFAULT) }) {
            InformationFooter()
        }

        item(span = { GridItemSpan(GRID_CELLS_DEFAULT) }) {
            Spacer(Modifier.height(19.dp))
        }
    }

}

@Composable
private fun CategoryContentCard(
    contentImg: String,
    contentTitle: String,
    contentPlace: String,
    contentPeriod: String,
    imageWidth: Dp,
    modifier: Modifier = Modifier,
    onContentClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.noRippleClickable { onContentClick() }
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(data = contentImg)
                .crossfade(enable = true)
                .build(),
            contentDescription = stringResource(R.string.category_detail_content_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(imageWidth)
                .aspectRatio(1f / 1.4f)
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = contentTitle,
            modifier = Modifier
                .fillMaxWidth(),
            color = Yes24TicketTheme.colorScheme.gray900,
            textAlign = TextAlign.Center,
            style = Yes24TicketTheme.typography.titleBold13,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )

        Text(
            text = contentPlace,
            modifier = Modifier
                .fillMaxWidth(),
            color = Yes24TicketTheme.colorScheme.gray800,
            textAlign = TextAlign.Center,
            style = Yes24TicketTheme.typography.captionMedium11,
        )

        Text(
            text = contentPeriod,
            modifier = Modifier
                .fillMaxWidth(),
            color = Yes24TicketTheme.colorScheme.gray300,
            textAlign = TextAlign.Center,
            style = Yes24TicketTheme.typography.captionMedium11
        )
    }
}

private const val GRID_CELLS_DEFAULT = 2

@Preview
@Composable
private fun CategoryDetailScreenPreview() {
    YES24TICKETTheme {
        val categoryContentList = listOf(
            CategoryContentEntity(
                contentId = 1,
                contentImg = "https://tkfile.yes24.com/upload2/perfblog/202411/20241119/20241119-51767.jpg/dims/quality/70/",
                contentTitle = "플라워 25주년 콘서트",
                contentPlace = "건국대학교 새천년관",
                contentPeriod = "2024. 12. 01 - 01. 15"
            ),
            CategoryContentEntity(
                contentId = 2,
                contentImg = "http://tkfile.yes24.com/upload2/perfblog/202411/20241108/20241108-51651.jpg/dims/quality/70/",
                contentTitle = "플라워 25주년 콘서트 플라워 25주년 콘서트 플라워 25주년 콘서트",
                contentPlace = "건국대학교 새천년관",
                contentPeriod = "2024. 12. 01 - 01. 15"
            ),
            CategoryContentEntity(
                contentId = 3,
                contentImg = "http://tkfile.yes24.com/upload2/perfblog/202408/20240813/20240813-50694.jpg/dims/quality/70/",
                contentTitle = "플라워 25주년 콘서트",
                contentPlace = "건국대학교 새천년관",
                contentPeriod = "2024. 12. 01 - 01. 15"
            ),
            CategoryContentEntity(
                contentId = 4,
                contentImg = "http://tkfile.yes24.com/upload2/perfblog/202411/20241114/20241114-51722.jpg/dims/quality/70/",
                contentTitle = "플라워 25주년 콘서트 플라워 25주년 콘서트 플라워 25주년 콘서트",
                contentPlace = "건국대학교 새천년관",
                contentPeriod = "2024. 12. 01 - 01. 15"
            ),
            CategoryContentEntity(
                contentId = 1,
                contentImg = "https://tkfile.yes24.com/upload2/perfblog/202411/20241119/20241119-51767.jpg/dims/quality/70/",
                contentTitle = "플라워 25주년 콘서트",
                contentPlace = "건국대학교 새천년관",
                contentPeriod = "2024. 12. 01 - 01. 15"
            ),
            CategoryContentEntity(
                contentId = 2,
                contentImg = "http://tkfile.yes24.com/upload2/perfblog/202411/20241108/20241108-51651.jpg/dims/quality/70/",
                contentTitle = "플라워 25주년 콘서트",
                contentPlace = "건국대학교 새천년관",
                contentPeriod = "2024. 12. 01 - 01. 15"
            ),
            CategoryContentEntity(
                contentId = 3,
                contentImg = "http://tkfile.yes24.com/upload2/perfblog/202408/20240813/20240813-50694.jpg/dims/quality/70/",
                contentTitle = "플라워 25주년 콘서트",
                contentPlace = "건국대학교 새천년관",
                contentPeriod = "2024. 12. 01 - 01. 15"
            ),
            CategoryContentEntity(
                contentId = 4,
                contentImg = "http://tkfile.yes24.com/upload2/perfblog/202411/20241114/20241114-51722.jpg/dims/quality/70/",
                contentTitle = "플라워 25주년 콘서트",
                contentPlace = "건국대학교 새천년관",
                contentPeriod = "2024. 12. 01 - 01. 15"
            ),
            CategoryContentEntity(
                contentId = 1,
                contentImg = "https://tkfile.yes24.com/upload2/perfblog/202411/20241119/20241119-51767.jpg/dims/quality/70/",
                contentTitle = "플라워 25주년 콘서트",
                contentPlace = "건국대학교 새천년관",
                contentPeriod = "2024. 12. 01 - 01. 15"
            ),
        )

        CategoryDetailScreen(categoryContentList = categoryContentList)
    }
}