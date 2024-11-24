package org.andsopt.android.yes24ticket.presentation.ui.category

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
import org.andsopt.android.yes24ticket.util.compose.noRippleClickable

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