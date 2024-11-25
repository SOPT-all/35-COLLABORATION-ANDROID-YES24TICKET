package org.andsopt.android.yes24ticket.presentation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.domain.model.LiveTicketRankingEntity
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme

@Composable
fun LiveTicketRankingLazyRow(
    ticketRankingList: List<LiveTicketRankingEntity>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(start = 10.dp, end = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(
            items = ticketRankingList,
            key = { ticketRanking -> ticketRanking.rank },
            contentType = { ticketRanking -> ticketRanking.imgUrl },
        ) { ticketRanking ->
            TicketRankingContent(
                ticketRanking = ticketRanking,
                imageWidth = 122.dp,
            )
        }
    }
}

@Composable
fun TicketRankingContent(
    ticketRanking: LiveTicketRankingEntity,
    imageWidth: Dp,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier =
        modifier
            .wrapContentSize(),
    ) {
        AsyncImage(
            model =
            ImageRequest.Builder(context = LocalContext.current)
                .data(ticketRanking.imgUrl)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.home_ticket_ranking_content_description),
            modifier =
            Modifier
                .width(imageWidth)
                .aspectRatio(1f / 1.45f)
                .clip(RoundedCornerShape(8.dp)),
        )

        Text(
            text = ticketRanking.rank.toString(),
            style = Yes24TicketTheme.typography.headBold36,
            color = Yes24TicketTheme.colorScheme.white,
            modifier = Modifier.padding(8.dp),
        )
    }
}

@Preview
@Composable
private fun RankingCardPreview() {
    TicketRankingContent(
        ticketRanking =
        LiveTicketRankingEntity(
            id =1,
            rank = 2,
            imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468505828994516.webp",
        ),
        imageWidth = 122.dp,
    )
}
