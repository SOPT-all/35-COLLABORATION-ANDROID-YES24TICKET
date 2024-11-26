package org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.domain.model.TicketPricingEntity
import org.andsopt.android.yes24ticket.presentation.type.TicketSeatType
import org.andsopt.android.yes24ticket.ui.theme.YES24TICKETTheme
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme
import org.andsopt.android.yes24ticket.util.compose.bottomBorder
import org.andsopt.android.yes24ticket.util.compose.topBorder

@Composable
fun TicketDetailSeatAndTime(
    ticketTime: List<String>,
    ticketTypeList: List<TicketPricingEntity>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .topBorder(color = Yes24TicketTheme.colorScheme.gray200, height = 1f)
            .bottomBorder(color = Yes24TicketTheme.colorScheme.gray200, height = 1f)
            .background(color = Yes24TicketTheme.colorScheme.gray100)
            .padding(horizontal = 14.dp, vertical = 15.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = stringResource(R.string.ticket_detail_title_seat_price),
            color = Yes24TicketTheme.colorScheme.blue500,
            style = Yes24TicketTheme.typography.titleBold15
        )

        SeatTypeAndPriceRow(ticketTypeList = ticketTypeList)

        Spacer(Modifier.height(10.dp))

        Text(
            text = stringResource(R.string.ticket_detail_title_time),
            color = Yes24TicketTheme.colorScheme.blue500,
            style = Yes24TicketTheme.typography.titleBold15
        )

        ticketTime.forEach { ticketTime ->
            Text(
                text = ticketTime,
                color = Yes24TicketTheme.colorScheme.gray700,
                style = Yes24TicketTheme.typography.bodyMedium13
            )
        }
    }
}

@Composable
private fun SeatTypeAndPriceRow(
    ticketTypeList: List<TicketPricingEntity>
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            ticketTypeList.forEach { ticketType ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(TicketSeatType.fromTypeId(ticketType.color)?.seatIcon ?: R.drawable.ic_ticket_detail_sit_violet_10),
                        contentDescription = stringResource(R.string.ticket_detail_seat_color),
                        modifier = Modifier.padding(4.dp),
                        tint = Color.Unspecified
                    )

                    Spacer(Modifier.width(4.dp))

                    Text(
                        text = ticketType.type,
                        color = Yes24TicketTheme.colorScheme.gray700,
                        style = Yes24TicketTheme.typography.bodyBold12
                    )
                }
            }
        }

        Spacer(Modifier.width(33.dp))

        Column {
            ticketTypeList.forEach { ticketType ->
                Text(
                    text = ticketType.price,
                    modifier = Modifier.padding(2.dp),
                    color = Yes24TicketTheme.colorScheme.black,
                    style = Yes24TicketTheme.typography.bodyBold12
                )
            }
        }
    }
}

@Preview
@Composable
private fun TicketDetailSeatAndTimePreview() {
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

        TicketDetailSeatAndTime(
            ticketTime = listOf("2024년 11월 10일(일) 5시 30분", "2024년 11월 11일(화) 7시 30분"),
            ticketTypeList = ticketType
        )
    }
}