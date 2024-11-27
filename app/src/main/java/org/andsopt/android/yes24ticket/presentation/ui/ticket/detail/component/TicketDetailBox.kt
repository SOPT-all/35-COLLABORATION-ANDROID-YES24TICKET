package org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.ui.theme.YES24TICKETTheme
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme
import org.andsopt.android.yes24ticket.util.compose.bottomBorder
import org.andsopt.android.yes24ticket.util.compose.noRippleClickable

@Composable
fun TicketDetailBox(
    ticketTitle: String,
    ticketPosterImg: String,
    ticketGenre: String,
    ticketDate: String,
    ticketPlace: String,
    ticketRatings: String,
    ticketRunningTime: String,
    likedCount: String,
    isLiked: Boolean,
    modifier: Modifier = Modifier,
    onLikedChanged: () -> Unit = {},
) {
    Box(
        modifier =
            modifier
                .fillMaxWidth()
                .background(Color.Transparent),
    ) {
        AsyncImage(
            model =
                ImageRequest.Builder(context = LocalContext.current)
                    .data(data = ticketPosterImg)
                    .crossfade(enable = true)
                    .build(),
            alignment = Alignment.TopCenter,
            contentDescription = stringResource(R.string.ticket_detail_poster_description),
            contentScale = ContentScale.FillWidth,
            modifier =
                Modifier
                    .matchParentSize(),
        )

        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(Yes24TicketTheme.colorScheme.whiteGd),
        ) {
            ExclusiveTicketChipAndTitle(
                ticketTitle = ticketTitle,
            )

            TicketDetailPosterAndDescription(
                ticketPosterImg = ticketPosterImg,
                ticketGenre = ticketGenre,
                ticketDate = ticketDate,
                ticketPlace = ticketPlace,
                ticketRatings = ticketRatings,
                ticketRunningTime = ticketRunningTime,
                imageWidth = (LocalConfiguration.current.screenWidthDp.dp) / (3.6f),
            )
        }

        Row(
            modifier =
                Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 8.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            LikedButton(
                likedCount = likedCount,
                isLiked = isLiked,
                onLikedChanged = onLikedChanged,
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_ticket_detail_share_36),
                contentDescription = stringResource(R.string.ticket_detail_share_description),
                tint = Color.Unspecified,
            )
        }
    }
}

@Composable
private fun ExclusiveTicketChipAndTitle(
    ticketTitle: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .bottomBorder(color = Yes24TicketTheme.colorScheme.gray200, height = 1f)
                .padding(vertical = 16.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        Text(
            text = stringResource(R.string.ticket_detail_exclusive),
            modifier =
                Modifier
                    .background(color = Yes24TicketTheme.colorScheme.red100, shape = RoundedCornerShape(2.dp))
                    .padding(horizontal = 4.dp, vertical = 3.dp),
            color = Yes24TicketTheme.colorScheme.white,
            style = Yes24TicketTheme.typography.captionBold10,
        )

        Spacer(Modifier.width(8.dp))

        Text(
            text = ticketTitle,
            color = Yes24TicketTheme.colorScheme.black,
            style = Yes24TicketTheme.typography.headExtraBold20,
        )
    }
}

@Composable
private fun TicketDetailPosterAndDescription(
    ticketPosterImg: String,
    ticketGenre: String,
    ticketDate: String,
    ticketPlace: String,
    ticketRatings: String,
    ticketRunningTime: String,
    imageWidth: Dp,
    modifier: Modifier = Modifier
) {
    Row(
        modifier =
            modifier
                .padding(vertical = 18.dp, horizontal = 10.dp),
    ) {
        AsyncImage(
            model =
                ImageRequest.Builder(context = LocalContext.current)
                    .data(data = ticketPosterImg)
                    .crossfade(enable = true)
                    .build(),
            contentDescription = stringResource(R.string.category_detail_content_description),
            contentScale = ContentScale.Crop,
            modifier =
                Modifier
                    .width(imageWidth)
                    .aspectRatio(1f / 1.4f),
        )

        Spacer(Modifier.width(16.dp))

        TicketDetailDescription(
            genre = ticketGenre,
            date = ticketDate,
            place = ticketPlace,
            filmRatings = ticketRatings,
            runningTime = ticketRunningTime,
        )
    }
}

@Composable
private fun TicketDetailDescription(
    genre: String,
    date: String,
    place: String,
    filmRatings: String,
    runningTime: String,
    modifier: Modifier = Modifier,
) {
    val labels =
        listOf(
            stringResource(R.string.ticket_detail_genre),
            stringResource(R.string.ticket_detail_date),
            stringResource(R.string.ticket_detail_place),
            stringResource(R.string.ticket_detail_film_ratings),
            stringResource(R.string.ticket_detail_running_time),
        )

    val details = listOf(genre, date, place, filmRatings, runningTime)

    Row(
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            labels.forEach { label ->
                Text(
                    text = label,
                    modifier = Modifier.padding(bottom = 1.dp),
                    color = Yes24TicketTheme.colorScheme.black,
                    style = Yes24TicketTheme.typography.bodySemiBold12,
                )
            }
        }

        Spacer(Modifier.width(13.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            details.forEachIndexed { index, detail ->
                if (index == 2) {
                    Row {
                        Text(
                            text = detail,
                            color = Yes24TicketTheme.colorScheme.blue500,
                            style = Yes24TicketTheme.typography.bodyBold13,
                        )

                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_right_blue_16),
                            contentDescription = stringResource(R.string.ticket_detail_place_description),
                            tint = Yes24TicketTheme.colorScheme.blue500,
                        )
                    }
                } else {
                    Text(
                        text = detail,
                        color = Yes24TicketTheme.colorScheme.gray800,
                        style = Yes24TicketTheme.typography.bodyRegular13,
                    )
                }
            }
        }
    }
}

@Composable
private fun LikedButton(
    isLiked: Boolean,
    likedCount: String,
    onLikedChanged: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier =
            modifier
                .noRippleClickable { onLikedChanged() },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector =
                if (isLiked) {
                    ImageVector.vectorResource(R.drawable.ic_ticket_detail_heart_selected_36)
                } else {
                    ImageVector.vectorResource(R.drawable.ic_ticket_detail_heart_deselected_36)
                },
            contentDescription = stringResource(R.string.ticket_detail_heart_description),
            tint = Color.Unspecified,
        )

        Text(
            text = likedCount,
            color = Yes24TicketTheme.colorScheme.gray600,
            style = Yes24TicketTheme.typography.buttonBold14,
        )
    }
}

@Preview
@Composable
private fun TicketDetailBoxPreview() {
    YES24TICKETTheme {
        TicketDetailBox(
            ticketTitle = "HYPE UP FESTIVAL",
            ticketPosterImg = "http://tkfile.yes24.com/upload2/PerfBlog/202409/20240906/20240906-50930.jpg",
            ticketGenre = "콘서트",
            ticketDate = "2024.11.10 ~ 2024.11.10",
            ticketPlace = "YES24 LIVE HALL",
            ticketRatings = "7세 이상",
            ticketRunningTime = "총 180분",
            likedCount = "162",
            isLiked = true,
            onLikedChanged = {},
        )
    }
}
