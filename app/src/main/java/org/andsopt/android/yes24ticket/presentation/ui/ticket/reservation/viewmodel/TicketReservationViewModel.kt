package org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.transformLatest
import org.andsopt.android.yes24ticket.domain.model.TimeSlotsDataEntity
import org.andsopt.android.yes24ticket.domain.repository.TicketingRepository
import java.time.DayOfWeek
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
@OptIn(ExperimentalCoroutinesApi::class)
class TicketReservationViewModel
    @Inject
    constructor(
        private val ticketingRepository: TicketingRepository,
    ) : ViewModel() {
        val dayOfWeeks =
            buildList {
                add(DayOfWeek.SUNDAY)
                addAll(
                    DayOfWeek.entries.filter {
                        it != DayOfWeek.SUNDAY && it != DayOfWeek.SATURDAY
                    },
                )
                add(DayOfWeek.SATURDAY)
            }

        private val _currentCalendar = MutableStateFlow(LocalDate.now())
        val currentCalendar = _currentCalendar.asStateFlow()

        val days: StateFlow<List<List<Int>>> =
            currentCalendar.map {
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
                initialValue = emptyList(),
            )

        val selectableDays =
            currentCalendar.transformLatest { currentCalendar ->
                emit(emptyList())
                ticketingRepository.fetchAvailableTimes(21) // TODO ticketId
                    .performanceTimes
                    .filter { it.monthValue == currentCalendar.monthValue }
                    .map { it.dayOfMonth }
                    .let { emit(it) }
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList(),
            )

        private val _selectedDay = MutableStateFlow(-1)
        val selectedDay = _selectedDay.asStateFlow()

        val currentTimeSlots =
            selectedDay.transformLatest {
                if (it == -1) {
                    return@transformLatest emit(TimeSlotsDataEntity(emptyList()))
                }
                emit(
                    ticketingRepository
                        .fetchTimeSlots(
                            "21",
                            currentCalendar.value.withDayOfMonth(it).toString(),
                        ),
                ) // TODO concertId
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = TimeSlotsDataEntity(emptyList()),
            )

        fun onDaySelected(day: Int) {
            if (day !in selectableDays.value) return
            if (selectedDay.value == day) {
                _selectedDay.value = -1
                return
            }
            _selectedDay.value = day
        }

        fun onNextMonth() {
            _currentCalendar.value = _currentCalendar.value.plusMonths(1)
            _selectedDay.value = -1
        }

        fun onPrevMonth() {
            _currentCalendar.value = _currentCalendar.value.minusMonths(1)
            _selectedDay.value = -1
        }
    }
