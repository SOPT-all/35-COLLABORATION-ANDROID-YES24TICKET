package org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.time.DayOfWeek
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class TicketReservationViewModel @Inject constructor(

) : ViewModel() {

    val dayOfWeeks = buildList {
        add(DayOfWeek.SUNDAY)
        addAll(DayOfWeek.entries.filter {
            it != DayOfWeek.SUNDAY && it != DayOfWeek.SATURDAY
        })
        add(DayOfWeek.SATURDAY)
    }

    private val _currentCalendar = MutableStateFlow(LocalDate.now())
    val currentCalendar = _currentCalendar.asStateFlow()

    val days: StateFlow<List<List<Int>>> = _currentCalendar.map {
        buildList {
            repeat(dayOfWeeks.indexOfFirst { dow -> dow == it.dayOfWeek }) {
                add(0)
            }
            addAll(1..it.lengthOfMonth())
            repeat(7 - (size % 7)) {
                add(0)
            }
        }.chunked(7)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )

    fun onNextMonth() {
        _currentCalendar.value = _currentCalendar.value.plusMonths(1)
    }

    fun onPrevMonth() {
        _currentCalendar.value = _currentCalendar.value.minusMonths(1)
    }
}