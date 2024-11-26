package org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme
import org.andsopt.android.yes24ticket.util.compose.noRippleClickable

@Composable
fun CalendarDaysRow(
    days: List<Int>,
    selectableDays: List<Int>,
    selectedDay: Int,
    modifier: Modifier = Modifier,
    onDaySelected: (Int) -> Unit = {},
) {
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        days.fastForEachIndexed { index, day ->
            Box(
                modifier =
                    Modifier
                        .height(IntrinsicSize.Min)
                        .weight(1f)
                        .aspectRatio(43f / 37f)
                        .background(
                            color =
                                if (selectedDay == day) {
                                    Yes24TicketTheme.colorScheme.red100
                                } else if (selectableDays.contains(day)) {
                                    Yes24TicketTheme.colorScheme.blue50
                                } else {
                                    Yes24TicketTheme.colorScheme.white
                                },
                        )
                        .noRippleClickable {
                            onDaySelected(day)
                        },
                contentAlignment = Alignment.Center,
            ) {
                if (day != 0) {
                    Text(
                        modifier = Modifier.padding(vertical = 6.dp),
                        text = day.toString(),
                        style = Yes24TicketTheme.typography.buttonSemiBold19,
                        color =
                            if (selectedDay == day) {
                                Yes24TicketTheme.colorScheme.white
                            } else {
                                Yes24TicketTheme.colorScheme.gray900
                            },
                        textAlign = TextAlign.Center,
                    )
                }
                if (index != days.lastIndex) {
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
