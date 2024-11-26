package org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme
import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun CalendarDayOfWeeksRow(
    dayOfWeeks: List<DayOfWeek>,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
    ) {
        dayOfWeeks.fastForEach { dayOfWeek ->
            Box(
                modifier =
                    Modifier
                        .height(IntrinsicSize.Min)
                        .weight(1f)
                        .background(
                            color = Yes24TicketTheme.colorScheme.gray100,
                        ),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 3.dp),
                    text = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN),
                    style = Yes24TicketTheme.typography.titleExtraBold12,
                    color =
                        when (dayOfWeek) {
                            DayOfWeek.SUNDAY -> Yes24TicketTheme.colorScheme.red100
                            DayOfWeek.SATURDAY -> Yes24TicketTheme.colorScheme.blue200
                            else -> Yes24TicketTheme.colorScheme.gray700
                        },
                )
                if (dayOfWeek != dayOfWeeks.last()) {
                    VerticalDivider(
                        modifier = Modifier.align(Alignment.CenterEnd),
                        thickness = 1.dp,
                        color = Yes24TicketTheme.colorScheme.gray150,
                    )
                }
            }
        }
    }
}
