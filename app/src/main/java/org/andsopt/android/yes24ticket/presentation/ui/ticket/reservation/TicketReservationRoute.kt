package org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.viewmodel.TicketReservationViewModel

@Composable
fun TicketReservationRoute(
    modifier: Modifier = Modifier,
    viewModel: TicketReservationViewModel = hiltViewModel(),
) {
    val dayOfWeeks = viewModel.dayOfWeeks
    val days by viewModel.days.collectAsStateWithLifecycle()
    val selectableDays by viewModel.selectableDays.collectAsStateWithLifecycle()
    val selectedDay by viewModel.selectedDay.collectAsStateWithLifecycle()
    val currentCalendar by viewModel.currentCalendar.collectAsStateWithLifecycle()
    val currentTimeSlots by viewModel.currentTimeSlots.collectAsStateWithLifecycle()

    TicketReservationScreen(
        modifier = modifier,
        dayOfWeeks = dayOfWeeks,
        days = days,
        selectableDays = selectableDays,
        selectedDay = selectedDay,
        currentCalendar = currentCalendar,
        currentTimeSlots = currentTimeSlots,
        onDaySelected = viewModel::onDaySelected,
        onNextMonth = viewModel::onNextMonth,
        onPrevMonth = viewModel::onPrevMonth,
        title = viewModel.title,
        place = viewModel.place,
    )
}
