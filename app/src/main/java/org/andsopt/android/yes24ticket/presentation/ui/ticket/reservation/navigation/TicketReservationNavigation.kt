package org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.andsopt.android.yes24ticket.presentation.ui.ticket.reservation.TicketReservationRoute
import org.andsopt.android.yes24ticket.ui.theme.Yes24TicketTheme

fun NavController.navigationTicketReservation(
    ticketId: Long,
    title: String,
    place: String,
) {
    navigate(
        route = TicketReservationRoute(ticketId, title, place),
    )
}

fun NavGraphBuilder.ticketReservationNavGraph() {
    composable<TicketReservationRoute> {
        TicketReservationRoute(
            modifier = Modifier.fillMaxSize().background(Yes24TicketTheme.colorScheme.white),
        )
    }
}

@Serializable
data class TicketReservationRoute(
    val ticketId: Long,
    val title: String,
    val place: String,
)
