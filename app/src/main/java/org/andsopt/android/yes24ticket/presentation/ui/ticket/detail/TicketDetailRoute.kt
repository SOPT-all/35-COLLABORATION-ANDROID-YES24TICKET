package org.andsopt.android.yes24ticket.presentation.ui.ticket.detail

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TicketDetailRoute(
    viewModel: TicketDetailViewModel = hiltViewModel(),
    navigateToTicketReservation: () -> Unit
) {
    TicketDetailScreen(
        ticketTitle = viewModel.mockData.ticketTitle,
        ticketPosterImg = viewModel.mockData.ticketImg,
        ticketGenre = viewModel.mockData.ticketGenre,
        ticketDate = viewModel.mockData.ticketDate,
        ticketPlace = viewModel.mockData.ticketArea,
        ticketRatings = viewModel.mockData.ticketAge,
        ticketRunningTime = viewModel.mockData.ticketDuration,
        likedCount = viewModel.mockData.ticketLikedCount,
        isLiked = true,
        ticketTime = viewModel.mockData.ticketPerformanceTimes,
        ticketTypeList = viewModel.mockData.ticketPricing,
        isExpanded = true,
        noticeText = viewModel.mockData.ticketNotice,
        hyperText = viewModel.mockData.ticketHyperText,
        onExpandedChanged = {},
        onLikedChanged = {}
    )
}