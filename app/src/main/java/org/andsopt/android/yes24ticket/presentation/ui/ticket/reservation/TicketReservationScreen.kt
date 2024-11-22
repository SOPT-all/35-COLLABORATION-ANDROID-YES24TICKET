package org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.andsopt.android.yes24ticket.presentation.ui.component.Yes24TopAppBar
import org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.viewmodel.TicketReservationViewModel

@Composable
fun TicketReservationScreen(
    modifier: Modifier = Modifier,
    viewModel: TicketReservationViewModel = hiltViewModel()
) {

    val dayOfWeeks = viewModel.dayOfWeeks
    val days by viewModel.days.collectAsStateWithLifecycle()
    val selectableDays by viewModel.selectableDays.collectAsStateWithLifecycle()
    val selectedDay by viewModel.selectedDay.collectAsStateWithLifecycle()

    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        Yes24TopAppBar()

        CalendarView(
            dayOfWeeks = dayOfWeeks,
            selectableDays = selectableDays,
            selectedDay = selectedDay,
            days = days,
            onDaySelected = viewModel::onDaySelected,
            modifier = Modifier.padding(top = 10.dp).padding(horizontal = 56.dp)
        )
    }
}
