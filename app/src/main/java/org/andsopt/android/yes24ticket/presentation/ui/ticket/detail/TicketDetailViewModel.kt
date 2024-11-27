package org.andsopt.android.yes24ticket.presentation.ui.ticket.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.andsopt.android.yes24ticket.domain.model.TicketDetailEntity
import org.andsopt.android.yes24ticket.domain.model.TicketPricingEntity
import org.andsopt.android.yes24ticket.domain.repository.TicketRepository
import org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.state.TicketDetailExpandableState
import org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.state.TicketDetailHeartState
import org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.state.TicketDetailUiState
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TicketDetailViewModel
@Inject
constructor(
    private val ticketRepository: TicketRepository
) : ViewModel() {
    private val _heartState = MutableStateFlow(TicketDetailHeartState())
    val heartState: StateFlow<TicketDetailHeartState>
        get() = _heartState.asStateFlow()

    private val _expandableState = MutableStateFlow(TicketDetailExpandableState())
    val expandableState: StateFlow<TicketDetailExpandableState>
        get() = _expandableState.asStateFlow()

    val categoryDetailUiState: StateFlow<TicketDetailUiState> =
        flow<TicketDetailUiState> {
            runCatching {
                ticketRepository.getTicketDetail(ticketId = 23)
            }.onSuccess { ticketDetail ->
                emit(TicketDetailUiState.Success(ticketDetail))
            }.onFailure { throwable ->
                emit(TicketDetailUiState.Error(throwable.message))
            }
        }.catch { throwable ->
            emit(TicketDetailUiState.Error(throwable.message))
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = TicketDetailUiState.Loading,
        )

    fun changeHeart() {
        fetchTicketDetailHeart()
        _heartState.value = _heartState.value.copy(isClicked = !_heartState.value.isClicked)
    }

    fun changeExpanded() {
        _expandableState.value = _expandableState.value.copy(isExpanded = !_expandableState.value.isExpanded)
    }

    private fun fetchTicketDetailHeart() {
        viewModelScope.launch {
            runCatching {
                ticketRepository.patchTicketDetailLike(ticketId = 23)
            }.onSuccess { detailLike ->
                _heartState.value = _heartState.value.copy(isClicked = detailLike.isLiked, likedCount = detailLike.likedCount)
                Timber.d("[티켓 상세] -> ${_heartState.value.likedCount}")
            }
        }
    }
}
