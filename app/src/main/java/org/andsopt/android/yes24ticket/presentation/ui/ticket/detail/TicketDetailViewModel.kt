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
import org.andsopt.android.yes24ticket.domain.model.TicketDetailEntity
import org.andsopt.android.yes24ticket.domain.model.TicketPricingEntity
import org.andsopt.android.yes24ticket.domain.repository.TicketRepository
import org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.state.TicketDetailExpandableState
import org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.state.TicketDetailHeartState
import org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.state.TicketDetailUiState
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
        // TODO 서버통신
        _heartState.value = _heartState.value.copy(isClicked = !_heartState.value.isClicked)
    }

    fun changeExpanded() {
        _expandableState.value = _expandableState.value.copy(isExpanded = !_expandableState.value.isExpanded)
    }

    val mockData =
        TicketDetailEntity(
            ticketId = "21",
            ticketTitle = "김창옥 토크콘서트",
            ticketArea = "영남대 천마아트센터",
            ticketImg = "http://tkfile.yes24.com/upload2/PerfBlog/202409/20240906/20240906-50930.jpg",
            ticketDate = "2024.11.10 ~ 2024.11.10",
            ticketDuration = "총 160분",
            ticketAge = "만 7세 이상",
            ticketHyperText = "HYPE UP FESTIVAL 바로가기",
            ticketLikedCount = "163",
            ticketNotice = listOf("※ 본 공연은 네이버 쿠폰이 적용되지 않습니다.", "※ 본 공연은 YES24공연에서 진행하는 할인쿠폰이벤트 대상에서 제외됩니다.", "※ 매수제한: 공연별 1인 4매"),
            ticketPerformanceTimes = listOf("2024-11-20 (수) 13:00", "2024-11-21 (목) 15:00", "2024-11-22 (금) 14:00", "2024-11-23 (토) 15:00"),
            ticketPricing =
                listOf(
                    TicketPricingEntity(
                        type = "R석",
                        price = "88,000원",
                        color = "2",
                    ),
                    TicketPricingEntity(
                        type = "S석",
                        price = "77,000원",
                        color = "3",
                    ),
                ),
        )
}
