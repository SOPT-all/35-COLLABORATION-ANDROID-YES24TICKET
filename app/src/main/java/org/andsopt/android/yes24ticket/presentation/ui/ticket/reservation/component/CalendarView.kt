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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastForEachIndexed
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme
import java.time.DayOfWeek

@Composable
fun CalendarView(
    dayOfWeeks: List<DayOfWeek>,
    selectableDays: List<Int>,
    days: List<List<Int>>,
    selectedDay: Int,
    currentYear: Int,
    currentMonth: Int,
    modifier: Modifier = Modifier,
    onDaySelected: (Int) -> Unit = {},
    onNextMonthClicked: () -> Unit = {},
    onPrevMonthClicked: () -> Unit = {},
) {
    Column(
        modifier = modifier,
    ) {
        CalendarMonthRow(
            onNextClicked = onNextMonthClicked,
            onPrevClicked = onPrevMonthClicked,
            year = currentYear,
            month = currentMonth,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        Column(
            modifier =
                Modifier
                    .padding(top = 10.dp)
                    .border(
                        width = 1.dp,
                        color = Yes24TicketTheme.colorScheme.gray150,
                        shape = RoundedCornerShape(2.dp),
                    )
                    .background(
                        color = Yes24TicketTheme.colorScheme.white,
                    ),
        ) {
            CalendarDayOfWeeksRow(
                dayOfWeeks = dayOfWeeks,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 2.dp, topEnd = 2.dp)),
            )
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Yes24TicketTheme.colorScheme.gray150,
            )
            days.fastForEach { weekDays ->
                CalendarDaysRow(
                    days = weekDays,
                    selectableDays = selectableDays,
                    selectedDay = selectedDay,
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .background(
                                color = Yes24TicketTheme.colorScheme.white,
                            ),
                    onDaySelected = onDaySelected,
                )
                if (weekDays != days.last()) {
                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(),
                        thickness = 1.dp,
                        color = Yes24TicketTheme.colorScheme.gray150,
                    )
                }
            }
        }
        Row(
            modifier =
                Modifier
                    .padding(top = 17.dp)
                    .align(Alignment.End),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            listOf(
                stringResource(R.string.reservation_available) to Yes24TicketTheme.colorScheme.blue50,
                stringResource(R.string.select) to Yes24TicketTheme.colorScheme.red100,
            ).fastForEachIndexed { index, (text, color) ->
                Box(
                    modifier =
                        Modifier
                            .size(9.dp)
                            .background(color = color),
                )

                Text(
                    text = text,
                    style = Yes24TicketTheme.typography.captionRegular10,
                    color = Yes24TicketTheme.colorScheme.gray400,
                    modifier = Modifier.padding(start = 3.dp),
                )
                if (index != 1) {
                    Spacer(modifier = Modifier.width(7.dp))
                }
            }
        }
    }
}

@Composable
@Preview
private fun CalendarViewPreview() {
    CalendarView(
        dayOfWeeks =
            listOf(
                DayOfWeek.SUNDAY,
                DayOfWeek.MONDAY,
                DayOfWeek.TUESDAY,
                DayOfWeek.WEDNESDAY,
                DayOfWeek.THURSDAY,
                DayOfWeek.FRIDAY,
                DayOfWeek.SATURDAY,
            ),
        selectableDays =
            listOf(
                11,
                14,
                20,
            ),
        selectedDay = 11,
        days =
            listOf(
                0, 0, 0, 0, 0, 1, 2,
                3, 4, 5, 6, 7, 8, 9,
                10, 11, 12, 13, 14, 15, 16,
                17, 18, 19, 20, 21, 22, 23,
                24, 25, 26, 27, 28, 29, 30,
                31, 0, 0, 0, 0, 0, 0,
            ).chunked(7),
        currentYear = 2024,
        currentMonth = 11,
    )
}
