package org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.domain.model.TimeSlotsDataEntity
import org.andsopt.android.yes24ticket.presentation.ui.component.Yes24TopAppBar
import org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.component.CalendarView
import org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.component.ReservationProgressRow
import org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.component.ReservationTitleRow
import org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.component.SelectConcertTimeView
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme
import java.time.DayOfWeek
import java.time.LocalDate

@Composable
fun TicketReservationScreen(
    dayOfWeeks: List<DayOfWeek>,
    days: List<List<Int>>,
    selectableDays: List<Int>,
    selectedDay: Int,
    currentCalendar: LocalDate,
    currentTimeSlots: TimeSlotsDataEntity,
    onDaySelected: (Int) -> Unit,
    onNextMonth: () -> Unit,
    onPrevMonth: () -> Unit,
    modifier: Modifier = Modifier,
    title: String,
    place: String,
) {
    Column(
        modifier = modifier,
    ) {
        Yes24TopAppBar()
        ReservationTitleRow()
        ReservationProgressRow(
            title = title,
            place = place,
            modifier = Modifier.background(Yes24TicketTheme.colorScheme.gray50)
        )

        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
        ) {
            CalendarView(
                dayOfWeeks = dayOfWeeks,
                selectableDays = selectableDays,
                selectedDay = selectedDay,
                days = days,
                onDaySelected = onDaySelected,
                modifier =
                    Modifier
                        .padding(top = 10.dp)
                        .padding(horizontal = 56.dp),
                currentYear = currentCalendar.year,
                currentMonth = currentCalendar.month.value,
                onNextMonthClicked = onNextMonth,
                onPrevMonthClicked = onPrevMonth,
            )

            SelectConcertTimeView(
                timeSlots = currentTimeSlots,
                modifier = Modifier.padding(top = 72.dp),
            )
        }
    }
}
