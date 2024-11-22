package org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastForEachIndexed
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun CalendarView(
    selectableDates: List<LocalDate>,
    days: List<List<Int>>,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier.border(
            width = 1.dp,
            color = Yes24TicketTheme.colorScheme.gray150,
            shape = RoundedCornerShape(4.dp)
        ).background(
            color = Yes24TicketTheme.colorScheme.white,
        )
    ) {
        CalendarDayOfWeeksRow(
            modifier = Modifier.fillMaxWidth()
        )
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Yes24TicketTheme.colorScheme.gray150
        )
        days.fastForEach { weekDays ->
            CalendarDaysRow(
                days = weekDays,
                selectableDates = selectableDates,
                modifier = Modifier.fillMaxWidth().background(
                    color = Yes24TicketTheme.colorScheme.white,
                )
            )
            if (weekDays != days.last()) {
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = Yes24TicketTheme.colorScheme.gray150
                )
            }
        }
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
        dayOfWeeks.fastForEach { dayOfWeek ->
            Box (
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .weight(1f)
                    .background(
                        color = Yes24TicketTheme.colorScheme.gray100,
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 3.dp),
                    text = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN),
                    style = Yes24TicketTheme.typography.titleExtraBold12,
                    color = when(dayOfWeek) {
                        DayOfWeek.SUNDAY -> Yes24TicketTheme.colorScheme.red100
                        DayOfWeek.SATURDAY -> Yes24TicketTheme.colorScheme.blue200
                        else -> Yes24TicketTheme.colorScheme.gray700
                    }
                )
                if (dayOfWeek != dayOfWeeks.last()) {
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
private fun CalendarDaysRow(
    days: List<Int>,
    selectableDates: List<LocalDate>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        days.fastForEachIndexed { index, day ->
            Box (
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .weight(1f)
                    .aspectRatio(43f / 37f)
                    .background(
                        color = Yes24TicketTheme.colorScheme.white,
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (day != 0)
                    Text(
                        modifier = Modifier.padding(vertical = 6.dp),
                        text = day.toString(),
                        style = Yes24TicketTheme.typography.buttonSemiBold19,
                        color = Yes24TicketTheme.colorScheme.gray900
                    )
                if (index != days.lastIndex) {
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
        ),
        days = listOf(0, 0, 0, 0, 0, 1, 2,
            3, 4, 5, 6, 7, 8, 9,
            10, 11, 12, 13, 14, 15, 16,
            17, 18, 19, 20, 21, 22, 23,
            24, 25, 26, 27, 28, 29, 30,
            31, 0, 0, 0, 0, 0, 0
        ).chunked(7),
    )
}