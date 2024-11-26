package org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme

@Composable
fun ReservationProgressRow(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier.fillMaxWidth()
                .padding(top = 8.dp),
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            text = "TODO: 콘서트 제목",
            style = Yes24TicketTheme.typography.headExtraBold17,
            color = Color(0xFF171717),
        )
        Row(
            modifier = Modifier.padding(top = 2.dp).padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "TODO: 콘서트 장소",
                style = Yes24TicketTheme.typography.titleRegular12,
                color = Yes24TicketTheme.colorScheme.gray500,
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier =
                    Modifier.size(10.dp).background(
                        color = Yes24TicketTheme.colorScheme.gray300,
                        shape = CircleShape,
                    ),
            )
            repeat(3) {
                Box(
                    modifier =
                        Modifier.padding(start = 6.dp).size(10.dp).border(
                            width = 1.dp,
                            color = Yes24TicketTheme.colorScheme.gray300,
                            shape = CircleShape,
                        ),
                )
            }
        }
        HorizontalDivider(
            modifier = Modifier.padding(top = 6.dp),
            color = Yes24TicketTheme.colorScheme.gray200,
        )
    }
}
