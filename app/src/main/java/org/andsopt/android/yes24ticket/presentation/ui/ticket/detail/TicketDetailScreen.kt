package org.andsopt.android.yes24ticket.presentation.ui.ticket.detail

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import org.andsopt.android.yes24ticket.domain.model.TicketDetailEntity
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
    ticketDetail: TicketDetailEntity,
    ticketTypeList: List<TicketPricingEntity>,
    isExpanded: Boolean,
    likedCount: String,
    isLiked: Boolean,
    modifier: Modifier = Modifier,
    onExpandedChanged: () -> Unit = {},
    onLikedChanged: () -> Unit = {},
) {
    Column(
        modifier =
            modifier
                .fillMaxSize(),
    ) {
        Yes24TopAppBar()

        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .verticalScroll(rememberScrollState()),
        ) {
            TicketDetailBox(
                ticketTitle = ticketDetail.ticketTitle,
                ticketPosterImg = ticketDetail.ticketImg,
                ticketGenre = ticketDetail.ticketGenre,
                ticketDate = ticketDetail.ticketDate,
                ticketPlace = ticketDetail.ticketArea,
                ticketRatings = ticketDetail.ticketAge,
                ticketRunningTime = ticketDetail.ticketDuration,
                likedCount = likedCount,
                isLiked = isLiked,
                onLikedChanged = onLikedChanged,
            )

            TicketDetailSeatAndTime(
                ticketTime = ticketDetail.ticketPerformanceTimes,
                ticketTypeList = ticketTypeList,
            )

            TicketDetailNotice(
                isExpanded = isExpanded,
                onExpandedChanged = onExpandedChanged,
                noticeText = ticketDetail.ticketNotice,
                hyperText = ticketDetail.ticketHyperText,
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
    modifier: Modifier = Modifier,
) {
    TicketDetailExpandableRow(
        modifier = modifier,
        titleText = R.string.ticket_detail_title_notice,
        isExpanded = isExpanded,
        onChangeExpanded = onExpandedChanged,
    ) {
        Column(
            modifier =
                Modifier
                    .padding(horizontal = 12.dp)
                    .padding(top = 12.dp),
        ) {
            noticeText.forEach { notice ->
                Text(
                    text = notice,
                    modifier = Modifier.padding(bottom = 6.dp),
                    color = Yes24TicketTheme.colorScheme.gray600,
                    style = Yes24TicketTheme.typography.bodyBold12,
                )
            }

            Spacer(Modifier.height(18.dp))

            Text(
                text = hyperText,
                modifier = Modifier.padding(vertical = 8.dp),
                color = Yes24TicketTheme.colorScheme.chipPurple,
                style = Yes24TicketTheme.typography.titleBold15,
            )
        }
    }
}

@Composable
private fun TicketDetailRow(
    @StringRes titleText: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .background(Yes24TicketTheme.colorScheme.white)
                .bottomBorder(color = Yes24TicketTheme.colorScheme.gray200, height = 1f),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(titleText),
            modifier =
                Modifier
                    .padding(start = 10.dp)
                    .padding(vertical = 13.dp),
            color = Yes24TicketTheme.colorScheme.gray700,
            style = Yes24TicketTheme.typography.titleBold15,
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_right_16),
            modifier =
                Modifier.padding(end = 7.dp),
            contentDescription = stringResource(titleText),
            tint = Yes24TicketTheme.colorScheme.gray400,
        )
    }
}

@Preview
@Composable
private fun TicketDetailScreenPreview() {
    YES24TICKETTheme {
        val ticketType =
            listOf(
                TicketPricingEntity(
                    type = "R석",
                    price = "88,000원",
                    color = "2",
                ),
                TicketPricingEntity(
                    type = "S석",
                    price = "77,000원",
                    color = "3",
                ),
            )

        TicketDetailScreen(
            ticketDetail =
                TicketDetailEntity(
                    ticketTitle = "HYPE UP FESTIVAL",
                    ticketImg = "http://tkfile.yes24.com/upload2/PerfBlog/202409/20240906/20240906-50930.jpg",
                    ticketGenre = "콘서트",
                    ticketDate = "2024.11.10 ~ 2024.11.10",
                    ticketArea = "YES24 LIVE HALL",
                    ticketAge = "7세 이상",
                    ticketDuration = "총 180분",
                    ticketPerformanceTimes = listOf("2024년 11월 10일(일) 5시 30분"),
                    ticketNotice = listOf("※ 본 공연은 네이버 쿠폰이 적용되지 않습니다.", "※ 본 공연은 YES24공연에서 진행하는 할인쿠폰이벤트 대상에서 제외됩니다.", "※ 매수제한: 공연별 1인 4매"),
                    ticketHyperText = "HYPE UP FESTIVAL 바로가기",
                    ticketLikedCount = "162",
                    ticketPricing = ticketType,
                    ticketId = "1",
                ),
            isLiked = true,
            ticketTypeList = ticketType,
            isExpanded = true,
            onLikedChanged = {},
            likedCount = "162",
        )
    }
}
