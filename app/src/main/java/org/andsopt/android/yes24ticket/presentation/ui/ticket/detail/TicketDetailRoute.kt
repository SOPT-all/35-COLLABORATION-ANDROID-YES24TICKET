package org.andsopt.android.yes24ticket.presentation.ui.ticket.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.state.TicketDetailUiState

@Composable
fun TicketDetailRoute(
    viewModel: TicketDetailViewModel = hiltViewModel(),
    // TODO navigateToTicketReservation: () -> Unit
) {
    val ticketDetailUiState by viewModel.categoryDetailUiState.collectAsStateWithLifecycle()
    val heartState by viewModel.heartState.collectAsStateWithLifecycle()
    val expandableState by viewModel.expandableState.collectAsStateWithLifecycle()

    when (ticketDetailUiState) {
        is TicketDetailUiState.Success -> {
            TicketDetailScreen(
                ticketDetail = (ticketDetailUiState as TicketDetailUiState.Success).ticketDetail,
                ticketTypeList = (ticketDetailUiState as TicketDetailUiState.Success).ticketDetail.ticketPricing,
                isExpanded = expandableState.isExpanded,
                isLiked = heartState.isClicked,
                likedCount = heartState.likedCount,
                onExpandedChanged = viewModel::changeExpanded,
                onLikedChanged = viewModel::changeHeart,
            )
        }

        else -> Unit
    }
}
