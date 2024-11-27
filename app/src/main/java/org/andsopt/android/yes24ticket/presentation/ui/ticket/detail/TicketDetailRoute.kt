package org.andsopt.android.yes24ticket.presentation.ui.ticket.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun TicketDetailRoute(
    viewModel: TicketDetailViewModel = hiltViewModel(),
    // TODO navigateToTicketReservation: () -> Unit
) {
    val heartState by viewModel.heartState.collectAsStateWithLifecycle()
    val expandableState by viewModel.expandableState.collectAsStateWithLifecycle()

    TicketDetailScreen(
        ticketDetail = viewModel.mockData,
        ticketTypeList = viewModel.mockData.ticketPricing,
        isExpanded = expandableState.isExpanded,
        isLiked = heartState.isClicked,
        onExpandedChanged = viewModel::changeExpanded,
        onLikedChanged = viewModel::changeHeart,
    )
}
