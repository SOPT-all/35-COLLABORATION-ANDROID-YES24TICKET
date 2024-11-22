package org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun CalendarView(
    selectableDates: List<LocalDate>,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier.border(
            width = 1.dp,
            color = Yes24TicketTheme.colorScheme.gray150,
            shape = RoundedCornerShape(2.dp)
        ),
    ) {
        CalendarDayOfWeeksRow(
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun CalendarDayOfWeeksRow(
    modifier: Modifier = Modifier
) {
    val dayOfWeeks = buildList {
        add(DayOfWeek.SUNDAY)
        addAll(DayOfWeek.entries.filter {
            it != DayOfWeek.SUNDAY && it != DayOfWeek.SATURDAY
        })
        add(DayOfWeek.SATURDAY)
    }

    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        dayOfWeeks.fastForEach {
            Box (
                modifier = Modifier.height(IntrinsicSize.Min).weight(1f).background(
                    color = Yes24TicketTheme.colorScheme.gray100,
                ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 3.dp),
                    text = it.getDisplayName(TextStyle.SHORT, Locale.KOREAN),
                    style = Yes24TicketTheme.typography.titleExtraBold12,
                    color = when(it) {
                        DayOfWeek.SUNDAY -> Yes24TicketTheme.colorScheme.red100
                        DayOfWeek.SATURDAY -> Yes24TicketTheme.colorScheme.blue200
                        else -> Yes24TicketTheme.colorScheme.gray700
                    }
                )
                if (it != dayOfWeeks.last()) {
                    VerticalDivider(
                        modifier = Modifier.align(Alignment.CenterEnd),
                        thickness = 1.dp,
                        color = Yes24TicketTheme.colorScheme.gray150
                    )
                }
            }
        }
    }
}

@Composable
@Preview
private fun CalendarViewPreview() {
    CalendarView(
        selectableDates = listOf(
            LocalDate.parse("2024-11-11"),
        )
    )
}