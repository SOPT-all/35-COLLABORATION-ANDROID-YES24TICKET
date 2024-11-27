package org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.state

import org.andsopt.android.yes24ticket.domain.model.TicketDetailEntity

sealed interface TicketDetailUiState {
    data class Success(val ticketDetail: TicketDetailEntity) : TicketDetailUiState

    data object Loading : TicketDetailUiState

    data class Error(val message: String?) : TicketDetailUiState
}
