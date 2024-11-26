package org.andsopt.android.yes24ticket.presentation.ui.ticket.detail

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.domain.model.TicketPricingEntity
import org.andsopt.android.yes24ticket.presentation.ui.component.InformationFooter
import org.andsopt.android.yes24ticket.presentation.ui.component.Yes24TopAppBar
import org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.component.TicketDetailBox
import org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.component.TicketDetailExpandableRow
import org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.component.TicketDetailReserveButton
import org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.component.TicketDetailSeatAndTime
import org.andsopt.android.yes24ticket.ui.theme.YES24TICKETTheme
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme
import org.andsopt.android.yes24ticket.util.compose.bottomBorder

@Composable
fun TicketDetailScreen(
    ticketTitle: String,
    ticketPosterImg: String,
    ticketGenre: String,
    ticketDate: String,
    ticketPlace: String,
    ticketRatings: String,
    ticketRunningTime: String,
    likedCount: String,
    isLiked: Boolean,
    ticketTime: List<String>,
    ticketTypeList: List<TicketPricingEntity>,
    isExpanded: Boolean,
    noticeText: List<String>,
    hyperText: String,
    onExpandedChanged: () -> Unit = {},
    onLikedChanged: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Yes24TopAppBar()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            TicketDetailBox(
                ticketTitle = ticketTitle,
                ticketPosterImg = ticketPosterImg,
                ticketGenre = ticketGenre,
                ticketDate = ticketDate,
                ticketPlace = ticketPlace,
                ticketRatings = ticketRatings,
                ticketRunningTime = ticketRunningTime,
                likedCount = likedCount,
                isLiked = isLiked,
                onLikedChanged = onLikedChanged
            )

            TicketDetailSeatAndTime(
                ticketTime = ticketTime,
                ticketTypeList = ticketTypeList
            )

            TicketDetailNotice(
                isExpanded = isExpanded,
                onExpandedChanged = onExpandedChanged,
                noticeText = noticeText,
                hyperText = hyperText,
            )

            TicketDetailRow(titleText = R.string.ticket_detail_title_detail)

            TicketDetailRow(titleText = R.string.ticket_detail_title_discount)

            TicketDetailRow(titleText = R.string.ticket_detail_title_expectations)

            TicketDetailRow(titleText = R.string.ticket_detail_title_image)

            TicketDetailRow(titleText = R.string.ticket_detail_title_information)

            InformationFooter()
        }

        TicketDetailReserveButton()
    }
}

@Composable
private fun TicketDetailNotice(
    isExpanded: Boolean,
    onExpandedChanged: () -> Unit,
    noticeText: List<String>,
    hyperText: String,
    modifier: Modifier = Modifier
) {
    TicketDetailExpandableRow(
        modifier = modifier,
        titleText = R.string.ticket_detail_title_notice,
        isExpanded = isExpanded,
        onChangeExpanded = onExpandedChanged
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(top = 12.dp)
        ) {
            noticeText.forEach { notice ->
                Text(
                    text = notice,
                    modifier = Modifier.padding(bottom = 6.dp),
                    color = Yes24TicketTheme.colorScheme.gray600,
                    style = Yes24TicketTheme.typography.bodyBold12
                )
            }

            Spacer(Modifier.height(18.dp))

            Text(
                text = hyperText,
                modifier = Modifier.padding(vertical = 8.dp),
                color = Yes24TicketTheme.colorScheme.chipPurple,
                style = Yes24TicketTheme.typography.titleBold15
            )
        }
    }
}

@Composable
private fun TicketDetailRow(
    @StringRes titleText: Int
) {
    Row(
        modifier = Modifier
            .background(Yes24TicketTheme.colorScheme.white)
            .bottomBorder(color = Yes24TicketTheme.colorScheme.gray200, height = 1f),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(titleText),
            modifier = Modifier
                .padding(start = 10.dp)
                .padding(vertical = 13.dp),
            color = Yes24TicketTheme.colorScheme.gray700,
            style = Yes24TicketTheme.typography.titleBold15
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_right_16),
            modifier = Modifier
                .padding(end = 7.dp),
            contentDescription = stringResource(titleText),
            tint = Yes24TicketTheme.colorScheme.gray400
        )
    }
}

@Preview
@Composable
private fun TicketDetailScreenPreview() {
    YES24TICKETTheme {
        val ticketType = listOf(
            TicketPricingEntity(
                type = "R석",
                price = "88,000원",
                color = "2"
            ),
            TicketPricingEntity(
                type = "S석",
                price = "77,000원",
                color = "3"
            ),
        )

        TicketDetailScreen(
            ticketTitle = "HYPE UP FESTIVAL",
            ticketPosterImg = "http://tkfile.yes24.com/upload2/PerfBlog/202409/20240906/20240906-50930.jpg",
            ticketGenre = "콘서트",
            ticketDate = "2024.11.10 ~ 2024.11.10",
            ticketPlace = "YES24 LIVE HALL",
            ticketRatings = "7세 이상",
            ticketRunningTime = "총 180분",
            likedCount = "162",
            isLiked = true,
            ticketTime = listOf("2024년 11월 10일(일) 5시 30분"),
            ticketTypeList = ticketType,
            isExpanded = true,
            noticeText = listOf("※ 본 공연은 네이버 쿠폰이 적용되지 않습니다.", "※ 본 공연은 YES24공연에서 진행하는 할인쿠폰이벤트 대상에서 제외됩니다.", "※ 매수제한: 공연별 1인 4매"),
            hyperText = "HYPE UP FESTIVAL 바로가기",
            onLikedChanged = {}
        )
    }
}