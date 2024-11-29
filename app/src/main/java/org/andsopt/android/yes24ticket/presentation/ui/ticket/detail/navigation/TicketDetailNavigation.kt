package org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import org.andsopt.android.yes24ticket.presentation.ui.ticket.detail.TicketDetailRoute

fun NavController.navigationTicketDetail(
    ticketId: Long
) {
    navigate(
        route = TicketDetailRoute(ticketId),
    )
}

fun NavGraphBuilder.ticketDetailNavGraph(
    navigationTicketReservation: (Long, String, String) -> Unit
) {
    composable<TicketDetailRoute> {
        TicketDetailRoute(
            navigateToTicketReservation = { ticketId, title, place ->
                navigationTicketReservation(ticketId, title, place)
            }
        )
    }
}

@Serializable
data class TicketDetailRoute(
    val ticketId: Long
)

