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
        ticketTitle = viewModel.mockData.ticketTitle,
        ticketPosterImg = viewModel.mockData.ticketImg,
        ticketGenre = viewModel.mockData.ticketGenre,
        ticketDate = viewModel.mockData.ticketDate,
        ticketPlace = viewModel.mockData.ticketArea,
        ticketRatings = viewModel.mockData.ticketAge,
        ticketRunningTime = viewModel.mockData.ticketDuration,
        likedCount = viewModel.mockData.ticketLikedCount,
        isLiked = heartState.isClicked,
        ticketTime = viewModel.mockData.ticketPerformanceTimes,
        ticketTypeList = viewModel.mockData.ticketPricing,
        isExpanded = expandableState.isExpanded,
        noticeText = viewModel.mockData.ticketNotice,
        hyperText = viewModel.mockData.ticketHyperText,
        onExpandedChanged = viewModel::changeExpanded,
        onLikedChanged = viewModel::changeHeart,
    )
}
